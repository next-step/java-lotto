package step1;

import org.junit.jupiter.api.Test;
import step1.Controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {
	@Test
	void divideTest(){
		String a = "15";
		String b = "3";
		CalculatorController calculatorController = new CalculatorController();
		assertEquals(calculatorController.divide(a, b), 5);
	}
}
