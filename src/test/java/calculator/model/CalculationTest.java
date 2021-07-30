package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.utils.ErrorMessage;

class CalculationTest {

	private Calculation calculation;

	@BeforeEach
	void setup() {
		calculation = new Calculation();
	}

	@Test
	@DisplayName("지정된 문자로 문자열을 분리하면 분리된다.")
	public void stringToSplit() {
		String[] result = calculation.stringToSplit("1!2!3", "!");

		assertThat(result.length).isEqualTo(3);
		assertThat(result).containsExactly("1", "2", "3");

		String[] result2 = calculation.stringToSplit("1@2@3", "@");

		assertThat(result2.length).isEqualTo(3);
		assertThat(result2).containsExactly("1", "2", "3");
	}

	@Test
	@DisplayName("문자열 배열을 입력하면 List 형태로 반환된다.")
	public void stringArrayToList() {
		String[] resultArray = calculation.stringToSplit("1,2,3,4:5", ",|:");
		List<String> characters = calculation.StringArrayToList(resultArray);
		assertThat(characters.size()).isEqualTo(5);
		assertThat(characters).containsExactly("1", "2", "3", "4", "5");
	}

	@Test
	@DisplayName("문자열의 배열에서 추출한 값이 숫자가 아니면 예외가 발생된다.")
	public void validNumberCheck() {
		List<String> characters = new ArrayList<>();
		characters.add("1");
		characters.add("3");
		characters.add("!");

		assertThrows(IllegalArgumentException.class, () ->
			calculation.plusCalculate(characters)
		);

		assertThatThrownBy(() -> calculation.plusCalculate(characters))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);

	}

	@Test
	@DisplayName("문자열의 배열에서 추출한 숫자값이 음수이면 예외가 발생된다.")
	public void validNumberPositiveCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			calculation.toInt("-2")
		);

		assertThatThrownBy(() -> calculation.toInt("-2"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.NUMBER_POSITIVE_ERROR_MESSAGE);

	}

	@Test
	@DisplayName("숫자 2개를 입력받으면 덧셈이 된다.")
	public void twoInputValuePlusCalculator() {
		int result1 = calculation.calculateReturnValue(10, "5");

		assertThat(result1).isEqualTo(15);

		int result2 = calculation.calculateReturnValue(6, "5");

		assertThat(result2).isEqualTo(11);

	}

	@Test
	@DisplayName("문자열을 입력하면 덧셈 계산기가가 동작한다.")
	public void plusCalculator() {
		List<String> characters = new ArrayList<>();
		characters.add("1");
		characters.add("3");
		characters.add("2");
		int result = calculation.plusCalculate(characters);

		assertThat(result).isEqualTo(6);

		characters.add("4");
		int result2 = calculation.plusCalculate(characters);

		assertThat(result2).isEqualTo(10);
	}

	@Test
	@DisplayName("문자 및 패턴을 입력하면 패턴별로 문자를 더한 값이반환된다.")
	public void calculateReturnValue() {
		int result1 = calculation.calculate(":", "1:2:3:4");

		assertThat(result1).isEqualTo(10);

		int result2 = calculation.calculate(":", "1:2:3:4:5");

		assertThat(result2).isEqualTo(15);
	}

}