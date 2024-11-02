/*package ie.atu.lab4;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDetails> handleValidationExceptions(MethodArgumentNotValidException ex){

        List<ErrorDetails> errors = new ArrayList<>();
        ex.getBindingResult().getFieldError().forEach(error ->{
            String fieldName = error.getField();
            String errorMessage = getDefaultMessage();
            ErrorDetails errorDetails = new ErrorDetails(fieldName. errorMessage);
            errors.add(errorDetails);
            )
        });

        return errors;
    }
}
*/