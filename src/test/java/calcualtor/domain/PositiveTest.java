package calcualtor.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveTest {
	@DisplayName("Positive 객체 생성 검증")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(strings = {"1", "2", "3", "4", "5"})
	void create(String input) {
		// when
		Positive positive = Positive.create(input);

		// then
		assertAll(
			() -> assertThat(positive).isNotNull(),
			() -> assertThat(positive).isEqualTo(new Positive(input))
		);
	}

	@DisplayName("0 또는 음수일 경우 RuntimeException 발생 검증")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(strings = {"0", "-1", "-2", "-3", "-4", "-5"})
	void createWithNegativeNumber(String input) {
		// when then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> Positive.create(input));
	}
}
