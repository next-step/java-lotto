package step1;

import org.junit.jupiter.api.Test;
import step1.Controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinusTest {
	@Test
	void minusTest(){
		String a = "3";
		String b = "1";
		CalculatorController calculatorController = new CalculatorController();
		assertEquals(calculatorController.minus(a, b), 2);
	}
}
