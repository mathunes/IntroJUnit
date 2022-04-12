package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		assertEquals(9, soma);		
	}
	
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(10, 5);
		assertEquals(5, subtracao);
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(5, 2);
		assertTrue(10 == multiplicacao);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		assertTrue(15 == somatoria);
	}

	@Test
	public void testEhPositivo() {
		boolean ehPositivo = calc.ehPositivo(10);
		assertTrue(ehPositivo);
	}
	
	@Test
	public void testComparaAMaiorQueB() {
		int compara = calc.compara(10, 5);
		assertTrue(compara == 1);
	}
	
	@Test
	public void testComparaAMenorQueB() {
		int compara = calc.compara(5, 10);
		assertTrue(compara == -1);
	}
	
	@Test
	public void testComparaAIgualB() {
		int compara = calc.compara(5, 5);
		assertTrue(compara == 0);
	}
	
}