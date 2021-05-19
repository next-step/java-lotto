package study.step2.domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberTest {

	@DisplayName("4-2-2-1-1.parse()_:_String을_int로_리턴")
	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(1)
	@CsvSource(value = {"one;1;false", "1;1;true", "zero;0;false", "12a;12;false", "1234;1234;true"}, delimiter = ';')
	void parseToInt(String text, int expectedNumber, boolean exceptedNotThrownException) {
		if (exceptedNotThrownException) {
			assertThat(Number.generate(text).getNumber()).isEqualTo(expectedNumber);
			return;
		}
		assertThatThrownBy(() -> Number.generate(text).getNumber()).isInstanceOf(NumberFormatException.class);
	}

	@DisplayName("4-2-2-1-2.parse():null_또는_\"\"입력시_0으로_리턴")
	@ParameterizedTest(name = "{index} - text : [{0}]")
	@Order(2)
	@ValueSource(strings = {"null", "", " "})
	void parseToIntWithNullAndEmpty(String str) {
		if ("null".equals(str)) {
			assertThat(Number.generate(null).getNumber()).isEqualTo(0);
			return;
		}
		assertThat(Number.generate(str).getNumber()).isEqualTo(0);
	}

	@DisplayName("4-2-2-1-3.parse()_:_음수_입력시_RuntimeException_발생")
	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(3)
	@CsvSource(value = {"1;1;true", "-1;-1;false", "12;12;true", "0;0;true", "-100;-100;false"}, delimiter = ';')
	void parseToIntWithoutNegative(String text, int expectedNumber, boolean exceptedNotThrownException) {
		if (exceptedNotThrownException) {
			assertThat(Number.generate(text).getNumber()).isEqualTo(expectedNumber);
			return;
		}
		assertThatThrownBy(() -> Number.generate(text).getNumber()).isInstanceOf(RuntimeException.class);
	}
}
