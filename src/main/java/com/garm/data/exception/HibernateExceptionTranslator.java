package com.garm.data.exception;

import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HibernateExceptionTranslator {

    public String translate(ConstraintViolationException ex) {

        // these are postgres sql exception code
        switch (ex.getSQLState()) {

            case "23503":
                return "error.repository.foreignKeyViolation";
            case "23505":
                return "repository.uniqueViolation";
            case "23502":
                return "error.repository.notNullViolation";
            default:
                return "error.orm.general";

        }
    }
}
