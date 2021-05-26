package lotto;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static type.LottoExceptionType.LOTTO_COUNT_OVER_PRICE;
import static type.LottoExceptionType.WRONG_LOTTO_COUNT;

class LottoCountTest {

	@Test
	@DisplayName("구매 가능한 로또 갯수보다 수동 로또 갯수가 높은 경우 테스트")
	void constructorOverUserCountTest(){
		assertThatThrownBy(() -> new LottoCount(new LottoMoney(10000), 11))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(LOTTO_COUNT_OVER_PRICE.message());
	}

	@Test
	@DisplayName("수동 로또 갯수가 0보다 작은 경우 테스트")
	void constructorUserCountUnderZeroTest(){
		assertThatThrownBy(() -> new LottoCount(new LottoMoney(10000), -1))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(WRONG_LOTTO_COUNT.message());
	}

	@Test
	@DisplayName("자동 로또 갯수 테스트")
	void autoCountTest() {
		// when
		LottoCount lottoCount = new LottoCount(new LottoMoney(10000), 3);

		// then
		assertThat(lottoCount.autoCount())
			.isEqualTo(7);
	}

	@Test
	@DisplayName("수동 로또 갯수 테스트")
	void userCount() {
		// when
		LottoCount lottoCount = new LottoCount(new LottoMoney(10000), 3);

		// then
		assertThat(lottoCount.userCount())
			.isEqualTo(3);
	}

	@Test
	@DisplayName("수동 로또 갯수가 0인지 테스트")
	void isEmptyUserCount() {
		// when
		LottoCount lottoCount = new LottoCount(new LottoMoney(10000), 0);

		// then
		assertThat(new LottoCount(new LottoMoney(10000), 0).isEmptyUserCount()).isTrue();
		assertThat(new LottoCount(new LottoMoney(10000), 3).isEmptyUserCount()).isFalse();
	}
}
