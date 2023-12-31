package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottoTest {
	@DisplayName("당첨 번호를 포함하는지 비교해서 포함하는 개수를 반환한다.")
	@Test
	void 당첨번호를_포함하는지_비교해서_개수를_반환한다() {
		Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 7);
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

		assertThat(lotto.contains(winningNumbers.lotto())).isEqualTo(5);
	}

	@DisplayName("로또 번호 6개 생성.")
	@Test
	void 로또_번호_6개_생성() {
		assertThat(Lotto.generate().get(0).isBetween(1, 45)).isTrue();
	}
}
