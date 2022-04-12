package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@Before
	public void inicializa() {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
        assertEquals("Introdução ao Teste de Software", livro.getNome());
        assertTrue(100.00 == livro.getPreco());
	}
	
	@Test
	public void testProdutosIguais() {
        Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
        assertNotSame(livro, livro2);
	}
	
	@Test
	public void testProdutosIguaisMetodos() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		assertTrue(livro.equals(livro2));
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
        assertThat(livro.getPreco(), equalTo(100.00));
        assertThat(livro.getNome(), notNullValue());
        assertThat(livro.getNome(), containsString("Teste"));
        assertThat(livro, instanceOf(Produto.class));
	}

}
