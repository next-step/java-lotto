package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.StringAdderException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testConstruct(String stringInput, int intInput) {
		assertThat(new Number(stringInput)).isEqualTo(new Number(intInput));
	}

	@DisplayName("객체 생성 실패 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "a"})
	void failTestConstruct(String stringInput) {
		assertThrows(StringAdderException.class, () -> new Number(stringInput));
	}

	@DisplayName("int값 얻는 메소드 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3"})
	void testIntValue(String stringInput) {
		assertThat(new Number(stringInput).intValue()).isEqualTo(Integer.parseInt(stringInput));
	}

	@DisplayName("더하기 연산 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
	void testSum(String one, String theOther, String result) {
		assertThat(Number.sum(new Number(one), new Number(theOther))).isEqualTo(new Number(result));
	}

}