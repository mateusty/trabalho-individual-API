package org.serratec.trabalhoIndividual.exception;

import java.util.List;

public class NotFoundException extends RuntimeException {

    private final List<String> erros;

    public NotFoundException(List<String> erros) {
        super(String.join(", ", erros));
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }
}
