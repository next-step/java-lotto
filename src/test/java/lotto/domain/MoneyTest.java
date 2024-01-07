package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class MoneyTest {
	@Test
	@DisplayName("전체 로또 개수 반환")
	void 전체_로또_개수_반환() {
		Money money = new Money(3000);
		int expectingResult = 3;

		assertThat(money.numberOfLotto(1)).isEqualTo(expectingResult);
	}

	@Test
	@DisplayName("수익률 계산")
	void 수익률_계산() {
		Money money = new Money(3000);
		LottoResult lottoResult = new LottoResult();
		float expectingResult = 0.0F;

		assertThat(money.calculateRate(lottoResult)).isEqualTo(expectingResult);
	}
}
