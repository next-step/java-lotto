package step1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlusTest {

	@Test
	void plusTest(){
		String a = "1";
		String b = "2";
		Calculator calculator = new Calculator();
		assertEquals(calculator.plus(a, b), 3);
	}
}
