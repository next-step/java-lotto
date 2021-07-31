package calculator.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.model.Character;

class CalculatorUtilsTest {

	@Test
	@DisplayName("문자열을 입력하는 패턴에 컬렉션에의하여 분리한다.")
	public void returnToArray() {
		CalculatorUtils calculatorUtils = new CalculatorUtils("1,2,3");

		List<Character> result = calculatorUtils.createCharacters();

		assertThat(result).extracting("character").containsExactly(1, 2, 3);

		CalculatorUtils calculatorUtils2 = new CalculatorUtils("//,\n1,2,3");

		List<Character> result2 = calculatorUtils2.createCharacters();

		assertThat(result2).extracting("character").containsExactly(1, 2, 3);
	}

}