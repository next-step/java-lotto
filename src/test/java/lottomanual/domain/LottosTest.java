package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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
		Lottos lottos = Lottos.of(amount);

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
		Lottos lottos = Lottos.of(amount);

		//when
		int size = lottos.size();

		//then
		assertThat(size).isEqualTo(lottoCount);
	}

	@Test
	@DisplayName("수동 번호 구매")
	void lotto_buy_manual() throws Exception {
		//given
		String[] lottoNumbers = {"1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"};

		//when
		Lottos lottos = Lottos.of(lottoNumbers);
		List<Lotto> lottos1 = lottos.toList();

		//then
		assertThat(lottos1).containsExactly(Lotto.of("1, 2, 3, 4, 5, 6"),
											Lotto.of("7, 8, 9, 10, 11, 12"));

	}

	@Test
	@DisplayName("로또 자동, 수동 복합 구매")
	void lotto_buy_composite() throws Exception {
		//given
		Lottos lottos = Lottos.of(2000, new String[]{"1, 2, 3, 4, 5, 6"});

		//when
		int size = lottos.size();

		//then
		assertThat(lottos.toList()).hasSize(2);
		assertThat(lottos.toList().get(0)).isEqualTo(Lotto.of("1, 2, 3, 4, 5, 6"));
	}

}
