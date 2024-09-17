package dio.me.RestSpringWeb.service;

import dio.me.RestSpringWeb.entity.Produto;
import dio.me.RestSpringWeb.exception.ProductNullException;
import dio.me.RestSpringWeb.exception.ProductPriceException;
import dio.me.RestSpringWeb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll () {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) throws Exception{
        if (Objects.isNull(produto.getNome()) || Objects.isNull(produto.getPreco()))
            throw new ProductNullException();
        if (produto.getPreco() < 0)
            throw new ProductPriceException();
        return produtoRepository.save(produto);
    }
}
