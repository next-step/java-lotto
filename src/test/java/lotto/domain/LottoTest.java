package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottoTest {
	@DisplayName("1~45 범위 안의 숫자인지 확인.")
	@Test
	void 범위_내의_숫자인지_확인() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Lotto(46);
			}).withMessage("1과 45 사이의 숫자를 입력해주세요.");
	}
}
