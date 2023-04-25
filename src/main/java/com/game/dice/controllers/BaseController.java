package  com.game.dice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
public class BaseController{


    public ResponseEntity<Object> sendResponse(Object result, String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", result);
        response.put("message", message);
        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<Object> sendError(String error, Map<String, String> errorMessages, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", error);
        if (!errorMessages.isEmpty()) {
            response.put("errors", errorMessages);
        }
        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<Object> sendInfo(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}
