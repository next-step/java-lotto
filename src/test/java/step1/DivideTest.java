package step1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {
	@Test
	void divideTest(){
		String a = "15";
		String b = "3";
		Calculator calculator = new Calculator();
		assertEquals(calculator.divide(a, b), 5);
	}
}
