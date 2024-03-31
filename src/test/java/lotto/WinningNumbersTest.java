package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumbersTest {
	@Test
	void 여섯개의_번호를_입력하지_않으면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(Set.of(1, 2, 3, 4, 5)))
				.withMessageMatching("당첨 번호는 6개를 입력해야 합니다.");
	}

	@Test
	void 당첨_번호는_1_미만_이면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(Set.of(0, 1, 2, 3, 4, 5)))
				.withMessageMatching("당첨 번호는 1 미만 45 초과인 수를 입력할 수 없습니다.");
	}

	@Test
	void 당첨_번호는_45_초과_이면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(Set.of(46, 1, 2, 3, 4, 5)))
				.withMessageMatching("당첨 번호는 1 미만 45 초과인 수를 입력할 수 없습니다.");
	}
}
