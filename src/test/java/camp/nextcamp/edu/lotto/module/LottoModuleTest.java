package camp.nextcamp.edu.lotto.module;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.WinningLotto;

public class LottoModuleTest {

	@ParameterizedTest
	@DisplayName("makeWinningLotto test")
	@ValueSource(strings = {"1, 3, 4, 5, 6, 7", "2, 3, 4, 5, 6, 7"})
	void makeWinningLotto_test(String input) {
		assertThat(LottoModule.getInstance().makeWinningLotto(input, "9"))
			.isInstanceOf(WinningLotto.class);
	}
}
