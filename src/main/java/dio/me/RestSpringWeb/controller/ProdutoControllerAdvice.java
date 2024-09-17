package dio.me.RestSpringWeb.controller;

import dio.me.RestSpringWeb.exception.ProductNullException;
import dio.me.RestSpringWeb.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNullException.class, ProductPriceException.class})
    public ResponseEntity<Object> capturaErroNull (Exception ex) {
        Map<String, Object> body = new HashMap<>();
        // Opcional: Adicionar o nome da excecao no corpo da resposta para mais clareza
        body.put("Error", ex.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
