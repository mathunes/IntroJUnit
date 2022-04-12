package carrinho;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

	private Carrinho carrinho;
	
	@Before
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@Test
	public void testAdicionarUmProduto() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		
		carrinho.addItem(produto1);
		
		assertTrue(1 == carrinho.getQtdeItems());
	}
	
	@Test
	public void testAdicionarDoisProdutos() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		Produto produto2 = new Produto("Título produto 2", 200.00);
		
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		assertTrue(2 == carrinho.getQtdeItems());
	}
	
	@Test
	public void testRemoverDeCarrinhoVazio() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(produto1));
	}
	
	@Test
	public void testRemoverUmProduto() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		
		carrinho.addItem(produto1);
		
		try {
			carrinho.removeItem(produto1);
		} catch (ProdutoNaoEncontradoException e) {
			fail();
		}
		
		assertTrue(0 == carrinho.getQtdeItems());
	}
	
	@Test
	public void testEsvaziarCarrinho() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		Produto produto2 = new Produto("Título produto 2", 200.00);
		
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		carrinho.esvazia();
		
		assertTrue(0 == carrinho.getQtdeItems());
	}
	
	@Test
	public void testGetValorTotal() {
		Produto produto1 = new Produto("Título produto 1", 100.00);
		Produto produto2 = new Produto("Título produto 2", 200.00);
		
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		assertTrue(300.00 == carrinho.getValorTotal());
	}
	
}
