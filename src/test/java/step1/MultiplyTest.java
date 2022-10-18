package step1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {
	@Test
	void multiplyTest(){
		String a = "3";
		String b = "5";
		Calculator calculator = new Calculator();
		assertEquals(calculator.multiply(a, b), 15);
	}
}
