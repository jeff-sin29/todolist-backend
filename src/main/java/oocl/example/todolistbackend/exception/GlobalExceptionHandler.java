package oocl.example.todolistbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTextFieldException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleEmployeeNotFoundException(InvalidTextFieldException ex) {}

    @ExceptionHandler(MissingTextFieldException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleEmployeeNotInAgeRangeException(MissingTextFieldException ex) {}

    @ExceptionHandler(UpdateNonExistingIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEmployeeAgeSalaryException(UpdateNonExistingIdException ex) {}

    @ExceptionHandler(IncompleteUpdatePayloadException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleIncompleteUpdatePayloadException(IncompleteUpdatePayloadException ex) {}

    @ExceptionHandler(DeleteInNonExistItemException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDeleteInNonExistItemException(DeleteInNonExistItemException ex) {}
}