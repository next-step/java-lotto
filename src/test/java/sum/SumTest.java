package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SumTest {

	@ParameterizedTest
	@DisplayName("기본 기능 테스트")
	@CsvSource(value = {"1,2,3;6", "1:3:5;9", "1,8:10;19"}, delimiter = ';')
	void sumTest(String sumParam, int answer) {
		int sum = Sum.sum(sumParam);

		assertThat(sum)
				.isEqualTo(answer);
	}

	@ParameterizedTest
	@DisplayName("유효성 검사 테스트")
	@ValueSource(strings = {"-5,0", "k:8", "0,,", "null", " : ,2"})
	void expectRunTimeException(String invalidParam) {
		assertThatThrownBy(()->Sum.sum(invalidParam))
				.isInstanceOf(RuntimeException.class);
	}
}
