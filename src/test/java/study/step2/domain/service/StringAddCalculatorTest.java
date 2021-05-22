package study.step2.domain.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step2.domain.aggregate.NumberGroup;
import study.step2.domain.value.InputText;
import study.step2.domain.value.Number;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringAddCalculatorTest {
	@DisplayName("4-2-4-1-1.sum() : NumberGroup의 값 모두 계산 - 기본구분자")
	@ParameterizedTest(name = "{index} - text : {0}, expectedSum : {1}, isNotThrowException : {2}")
	@Order(1)
	@CsvSource(value = {"1,2|3|true", "1:2|3|true", "1,2:3|6|true",
		"12,12:12|36|true", "12;12|24|false"}, delimiter = '|')
	void split(String text, int expectedSum, boolean isNotThrowException) {
		//given

		//when
		if (isNotThrowException) {
			//then
			List<Number> numbers = NumberGroup.generate(InputText.split(text)).numbers();
			assertThat(StringAddCalculator.sum(numbers)).isEqualTo(expectedSum);
			return;
		}
		//then - throw RuntimeException
		assertThatThrownBy(() -> NumberGroup.generate(InputText.split(text)).numbers())
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("4-2-4-1-2.sum() : NumberGroup의 값 모두 계산 - 기본구분자 + 커스텀구분자")
	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(2)
	@ValueSource(strings = {"//;\n1;2;3!!!6!!!true", "//;\n1:2,3;4!!!10!!!true", "1,2;3,3,3!!!12!!!false"})
	void splitWithCustomDelimiter(String valueSource) {
		//given
		String[] expectedValues = valueSource.split("!!!");
		String text = expectedValues[0];
		int expectedSum = Integer.parseInt(expectedValues[1]);
		boolean isNotThrowException = Boolean.valueOf(expectedValues[2]);

		//when
		if (isNotThrowException) {
			//then
			List<Number> numbers = NumberGroup.generate(InputText.split(text)).numbers();
			assertThat(StringAddCalculator.sum(numbers)).isEqualTo(expectedSum);
			return;
		}
		//then - throw RuntimeException
		assertThatThrownBy(() -> NumberGroup.generate(InputText.split(text)).numbers())
			.isInstanceOf(RuntimeException.class);
	}
}
