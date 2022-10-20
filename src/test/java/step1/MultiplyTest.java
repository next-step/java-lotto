package step1;

import org.junit.jupiter.api.Test;
import step1.Controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {
	@Test
	void multiplyTest(){
		String a = "3";
		String b = "5";
		CalculatorController calculatorController = new CalculatorController();
		assertEquals(calculatorController.multiply(a, b), 15);
	}
}
