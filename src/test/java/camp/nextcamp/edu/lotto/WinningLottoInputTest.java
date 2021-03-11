package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.WinningLottoInput;

public class WinningLottoInputTest {

	@ParameterizedTest
	@DisplayName(",로 안자르는경우")
	@ValueSource(strings = {"1!3!4$567", "1 2 3 4 5 6"})
	void split_error(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new WinningLottoInput(input))
			.withMessageMatching(",  단위로 잘라서 입력해주세요.");
	}

	@ParameterizedTest
	@DisplayName("숫자가 아닌경우")
	@ValueSource(strings = {"a, b, c, d, e, f", "h, i, j, k, l, o"})
	void number_error(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new WinningLottoInput(input))
			.withMessageMatching("숫자만 입력이 가능합니다.");
	}

	@ParameterizedTest
	@DisplayName("성공 케이스")
	@ValueSource(strings = {"1, 3, 4, 5, 6, 22", "1, 2, 3, 33, 5, 6"})
	void success(String input) {
		assertThat(new WinningLottoInput(input))
			.isInstanceOf(WinningLottoInput.class);
	}
}
