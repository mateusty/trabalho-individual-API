package org.serratec.trabalhoIndividual.model;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(String error, LocalDateTime dateTime) {
}
