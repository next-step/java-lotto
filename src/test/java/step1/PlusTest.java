package step1;

import org.junit.jupiter.api.Test;
import step1.Controller.CalculatorController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlusTest {

	@Test
	void plusTest(){
		String a = "1";
		String b = "2";
		CalculatorController calculatorController = new CalculatorController();
		assertEquals(calculatorController.plus(a, b), 3);
	}
}
