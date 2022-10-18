package step1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinusTest {
	@Test
	void minusTest(){
		String a = "3";
		String b = "1";
		Calculator calculator = new Calculator();
		assertEquals(calculator.minus(a, b), 2);
	}
}
