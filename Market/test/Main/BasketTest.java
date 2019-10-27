package Main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasketTest {

	@Test
	public void testEB() {
		Basket basket = new Basket();
		Integer expected = 210;
		Integer actual = basket.checkout("EBEEBBBB");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEBF() {
		Basket basket = new Basket();
		Integer expected = 230;
		Integer actual = basket.checkout("EBEEBBBBFF");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEBF2() {
		Basket basket = new Basket();
		Integer expected = 230;
		Integer actual = basket.checkout("FEBEEBBBBFF");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMany() {
		Basket basket = new Basket();
		Integer expected = 680;
		Integer actual = basket.checkout("KFEBEQEKUBRQBBBRFFRUUU");
		assertEquals(expected, actual);
	}

}
