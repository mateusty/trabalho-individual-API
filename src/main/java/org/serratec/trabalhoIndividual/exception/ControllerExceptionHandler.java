package org.serratec.trabalhoIndividual.exception;

import org.serratec.trabalhoIndividual.model.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(field -> field.getDefaultMessage())
                .collect(Collectors.joining(" : "));

        return super.handleExceptionInternal(ex, new ErrorResponse(errors, LocalDateTime.now()), headers, status, request);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(getMessageDetails(ex), LocalDateTime.now()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    private String getMessageDetails(DataIntegrityViolationException ex) {
        String mensagem = "";

        if(ex.getRootCause() != null) {
            mensagem = ex.getRootCause().getMessage();
        }

        if(mensagem.contains("email")) {
            return "Este email já está em uso";
        }
        else if(mensagem.contains("cpf")) {
            return "Este cpf já está em uso";
        }
        else if(mensagem.contains("telefone")) {
            return "Este telefone já está em uso";
        }
        return "Há uma violação de integridade dos dados na requisição";
    }
}
