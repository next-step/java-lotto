package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

	@ParameterizedTest(name = "금액별 로또 수량 {index} [{arguments}]")
	@CsvSource(value = {
			"14000,14",
			"1000,1",
			"1500,1"
	})
	@DisplayName("금액별 로또 수량")
	void lotto_by_amount_create(int amount, int lottoCount) throws Exception {
		//given
		Lottos lottos = new Lottos(amount, LottoNumberShuffle.generate());

		//when
		int size = lottos.size();

		//then
		assertThat(size).isEqualTo(lottoCount);
	}


	@ParameterizedTest(name = "금액별 로또 수량 구입 {index} [{arguments}]")
	@CsvSource(value = {
			"14000,14",
			"1000,1",
			"1500,1"
	})
	@DisplayName("금액별 로또 수량 구입")
	void lotto_by_amount_buy(int amount, int lottoCount) throws Exception {
		//given
		Lottos lottos = new Lottos();

		//when
		lottos.buy(amount, LottoNumberShuffle.generate());
		int size = lottos.size();

		//then
		assertThat(size).isEqualTo(lottoCount);
	}
}
