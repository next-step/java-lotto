package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SumTest {

	@ParameterizedTest
	@DisplayName("기본 기능 테스트")
	@CsvSource(value = {"1,2,3;6",
			"1:3:5;9",
			"1,8:10;19",
			"3,:;3"}, delimiter = ';')
	void sumTest(String sumParam, int answer) {
		int sum = Sum.sum(sumParam);

		assertThat(sum)
				.isEqualTo(answer);
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	@DisplayName("빈 값 처리 테스트")
	void nullOrEmptyTest(String param) {
		int sum = Sum.sum(param);
		assertThat(sum)
				.isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("유효성 검사 테스트")
	@ValueSource(strings = {"-5,0", "k:8", "null"})
	void expectRunTimeException(String invalidParam) {
		assertThatThrownBy(() -> Sum.sum(invalidParam))
				.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("구분자 기능 테스트")
	void delimiterTest() {
		int sum = Sum.sum("//;\n1;2;;3");
		assertThat(sum)
				.isEqualTo(6);
	}
}
