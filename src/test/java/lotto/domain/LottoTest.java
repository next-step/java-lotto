package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottoTest {
	@DisplayName("로또 번호 6개 생성.")
	@Test
	void 로또_번호_6개_생성() {
		Lotto lotto = new Lotto();

		assertThat(lotto.generate().get(0).isBetween(1, 45)).isTrue();
	}
}
