package org.codejudge.sb.error.handler;

import org.codejudge.sb.error.exception.LeadsException;
import org.codejudge.sb.model.EmptyResponseDto;
import org.codejudge.sb.model.ErrorDto;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
@Order(0)
public class LeadsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LeadsException.class)
    public final ResponseEntity handleLeadsException(LeadsException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage());
        if (exception.getEmpty()) {
            return new ResponseEntity<>(new EmptyResponseDto(), exception.getStatus());
        }
        return new ResponseEntity<>(errorDto, exception.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleUnknownException(Exception exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
