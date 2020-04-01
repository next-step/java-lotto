package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {
	@Test
	void isEqualsTest() {
		assertThat(new LottoMoney(1500))
				.isEqualTo(new LottoMoney(1500));
	}

	@Test
	@DisplayName("생성자 예외처리 테스트")
	void constructorExpectExceptionTesT() {
		assertThatThrownBy(() -> new LottoMoney(-1))
				.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@DisplayName("로또 개수 확인 테스트")
	@CsvSource(value = {
			"0,0",
			"3000,3",
			"3999,3"})
	void getLottoNumberCountTest(long money, int count) {
		LottoMoney lottoMoney = new LottoMoney(money);
		assertThat(lottoMoney.getLottoNumbersCount())
				.isEqualTo(count);
	}
}