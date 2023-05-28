package restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import restaurant.model.ErrorResponse;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Exception handler that maps exceptions on response status codes.
 */
@ControllerAdvice(basePackageClasses = OrderController.class)
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * Handles all errors that are not handled specifically by another handler and returns 500.
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse internalServerError(final Throwable exception) {
        logger.error("Internal Server Error: " + exception.getMessage(), exception);
        return new ErrorResponse(exception.getMessage());
    }
}