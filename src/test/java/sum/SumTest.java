package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest {

	@ParameterizedTest
	@DisplayName("기본 기능 테스트")
	@CsvSource(value = {"1,2,3;6", "1:3:5;9", "1,8:10;19"}, delimiter = ';')
	void sumTest(String sumParam, int answer) {
		int sum = Sum.sum(sumParam);

		assertThat(sum)
				.isEqualTo(answer);
	}
}
