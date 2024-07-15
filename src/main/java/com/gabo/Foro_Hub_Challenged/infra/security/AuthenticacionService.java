package com.gabo.Foro_Hub_Challenged.infra.security;

import com.gabo.Foro_Hub_Challenged.domain.user.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticacionService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private AuthenticacionService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        return usuarioRepository.findByCorreoElectronico(correo);
    }
}
