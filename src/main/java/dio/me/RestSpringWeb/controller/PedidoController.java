package dio.me.RestSpringWeb.controller;

import dio.me.RestSpringWeb.entity.Pedido;
import dio.me.RestSpringWeb.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;
}
