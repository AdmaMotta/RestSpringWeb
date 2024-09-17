package dio.me.RestSpringWeb.controller;

import dio.me.RestSpringWeb.entity.Pedido;
import dio.me.RestSpringWeb.entity.Produto;
import dio.me.RestSpringWeb.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvaProduto (@RequestBody Pedido pedido) throws Exception {
        return ResponseEntity.ok().body(pedidoService.save(pedido));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscaProduto (@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @GetMapping(value = "/busca_todos")
    public ResponseEntity<List<Pedido>> buscaTodosProdutos () {
        return ResponseEntity.ok().body(pedidoService.findAll());
    }
}
