package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperandTest {
	@Test
	@DisplayName("저장된 숫자를 반환한다.")
	void getNumberTest() {
		int number = 5;
		Operand operand = new Operand(number);

		Assertions.assertEquals(number, operand.getNumber());
	}
}
