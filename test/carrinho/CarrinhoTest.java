package carrinho;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import produto.Produto;

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
	
}
