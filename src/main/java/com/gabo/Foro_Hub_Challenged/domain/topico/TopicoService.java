package com.gabo.Foro_Hub_Challenged.domain.topico;

import com.gabo.Foro_Hub_Challenged.domain.curso.Curso;
import com.gabo.Foro_Hub_Challenged.domain.curso.CursoRepository;
import com.gabo.Foro_Hub_Challenged.domain.topico.validaciones.ValidadorDeTopicos;
import com.gabo.Foro_Hub_Challenged.domain.user.Usuario;
import com.gabo.Foro_Hub_Challenged.domain.user.UsuarioRepository;
import com.gabo.Foro_Hub_Challenged.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final List<ValidadorDeTopicos> validaciones;

    public TopicoService(TopicoRepository topicoRepository,
                         UsuarioRepository usuarioRepository,
                         CursoRepository cursoRepository,
                         List<ValidadorDeTopicos> validaciones) {

        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.validaciones = validaciones;
    }
    public Topico registrarTopico(RequestTopicoDTO datos){

        if(!usuarioRepository.findById(datos.usuarioId()).isPresent()){
            throw new ValidacionDeIntegridad("este id para el usuario no fue encontrado");
        }
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }

        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }

        Curso curso = cursoRepository.findByNombre(datos.curso());
        Usuario usuario = usuarioRepository.getReferenceById(datos.usuarioId());
        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                usuario,
                curso
        );
        topicoRepository.save(topico);

        return topico;
    }

    public Topico actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datos){
        Topico topico = topicoRepository.getReferenceById(id);
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }
        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }
        Curso curso = cursoRepository.findByNombre(datos.curso());
        topico.actualizarTopico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                curso
        );
        return topico;
    }

}
