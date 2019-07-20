package org.codejudge.sb.error.exception;

import org.springframework.http.HttpStatus;

public class LeadsException extends Throwable {

    private HttpStatus status;
    private Boolean isEmpty;

    public LeadsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public LeadsException(String message, HttpStatus status, Boolean isEmpty) {
        super(message);
        this.status = status;
        this.isEmpty = isEmpty;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }
}
