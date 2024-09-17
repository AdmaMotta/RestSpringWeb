package dio.me.RestSpringWeb.controller;

import dio.me.RestSpringWeb.entity.Produto;
import dio.me.RestSpringWeb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto (@RequestBody Produto produto) throws Exception {
        return ResponseEntity.ok().body(produtoService.save(produto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto (@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @GetMapping(value = "/busca_todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos () {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

}
