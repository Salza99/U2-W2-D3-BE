package Davide.U2W2D3BE.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ErrorsPayload {
    private String message;
    private LocalDate timeStamp;
}
