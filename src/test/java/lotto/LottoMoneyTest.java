package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static type.LottoExceptionType.WRONG_LOTTO_PRICE;

class LottoMoneyTest {


	@Test
	@DisplayName("음수 금액일때 Exception 검증 테스트")
	void constructorTestWithNegative() {
		assertThatThrownBy(() -> new LottoMoney(-1000))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(WRONG_LOTTO_PRICE.message());

	}

	@Test
	@DisplayName("0 금액일때 Exception 검증 테스트")
	void constructorTestWithZero() {
		assertThatThrownBy(() -> new LottoMoney(0))
			.isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	@DisplayName("금액에 맞춰 살수 있는 로또의 갯수 반환 테스트")
	void calculateLottoCountTest() {
		assertThat(new LottoMoney(10000).calculateLottoCount())
			.isEqualTo(10);
	}
}
