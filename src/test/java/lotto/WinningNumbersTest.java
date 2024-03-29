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
}
