package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

	@Test
	@DisplayName("돈과 수동 구매 로또 수를 알면 자동 로또 수도 알 수 있다.")
	public void getAutoCountTest() {
		LottoCount lottoCount = LottoCount.of(Money.ofWons(14000), 3);

		assertThat(lottoCount.getAutoCount()).isEqualTo(11);
	}

	@Test
	@DisplayName("입력 돈에 비해 수동 구매 로또 수가 많으면 돈이 모자르다고 예외가 발생한다.")
	public void notEnoughMoneyTest() {
		assertThatThrownBy(() -> LottoCount.of(Money.ofWons(100), 1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("돈이 모자랍니다.");
	}

	@Test
	@DisplayName("수동 구매 로또 수는 0 이상이어야 한다.")
	public void nonNegativeManualCountTest() {
		assertThatThrownBy(() -> LottoCount.of(Money.ofWons(100), -1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("수동 구매 로또 수는 0 이상이어야 합니다.");
	}

}
