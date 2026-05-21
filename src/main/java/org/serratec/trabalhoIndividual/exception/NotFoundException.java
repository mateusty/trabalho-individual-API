package org.serratec.trabalhoIndividual.exception;

import java.util.List;

public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}
