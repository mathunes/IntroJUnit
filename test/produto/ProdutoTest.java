package produto;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@Before
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
            assertEquals("Introdu��o ao Teste de Software", livro.getNome());
            assertTrue(100.00 == livro.getPreco());
	}
	
	@Test
	public void testProdutosIguais() {
            Produto livro2 = new Produto("Introdu��o ao Teste de Software", 90.00);
            assertNotSame(livro, livro2);
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
            assertThat(livro.getPreco(), equalTo(100.00));
            assertThat(livro.getNome(), notNullValue());
            assertThat(livro.getNome(), containsString("Teste"));
            assertThat(livro, instanceOf(Produto.class));
	}

}
