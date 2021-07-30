package calculator.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculationTest {

	@Test
	@DisplayName("입력받은 문자열이 생성되면 덧셈 계산기가가 동작한다.")
	public void plusCalculator() {
		Characters characters = new Characters(getCharacter(1), getCharacter(2), getCharacter(3), getCharacter(4));

		Calculation calculation = new Calculation(characters);

		int result = calculation.calculate();

		assertThat(result).isEqualTo(10);

		String[] testValue = {"1","2","3","4"};
		Calculation calculation2 = new Calculation(testValue);

		int result2 = calculation2.calculate();

		assertThat(result2).isEqualTo(10);

	}

	private Character getCharacter(int value){
		return new Character(value);
	}

}