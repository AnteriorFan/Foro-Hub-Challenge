package com.gabo.Foro_Hub_Challenged.domain.topico;

import jakarta.validation.constraints.NotNull;

public record RequestTopicoDTO(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long usuarioId,
        @NotNull
        String curso
) {
}
