package com.collins.expensetrackerapp.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDetails DTO (Data Transfer Object) to transfer error details from client to server "
)
@Getter
@Setter
public class ErrorDetails {
    @Schema(
            description = "Error Occurred Data Time"
    )
    private LocalDateTime timeStamp;
    @Schema(
            description = "Error message"
    )
    private String message;
    @Schema(
            description = "Error details"
    )
    private String details;
    @Schema(
            description = "Error code"
    )
    private String errorCode;
}
