package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitTest {

	@Test
	@DisplayName("잘못된 일치 수를 입력하는 경우 기본값 리턴")
	void lotto_profit() throws Exception {
		//given
		int quantity = 7;

		//when
		LottoProfit profit = LottoProfit.of(quantity, false);

		//then
		assertThat(profit).isEqualTo(LottoProfit.ZERO);
	}

	@ParameterizedTest(name = "당첨당 합산 금액 {index} [{arguments}]")
	@CsvSource(value = {
			"3,1,true,5000",
			"3,2,false,10000",
			"4,1,true,50000",
			"4,2,false,100000",
			"5,1,false,1500000",
			"5,2,false,3000000",
			"5,1,true,30000000",
			"5,2,true,60000000",
			"6,1,true,2000000000",
			"6,2,false,4000000000"
	})
	void profit_sum(int quantity, int matchingCount, boolean matchBonus, long totalProfit) throws Exception {
		//given
		LottoProfit lottoProfit = LottoProfit.of(quantity, matchBonus);

		//when
		long profit = lottoProfit.profit(matchingCount);

		//then
		assertThat(profit).isEqualTo(totalProfit);
	}

	@Test
	@DisplayName("보너스 번호 일치")
	void match_bonus() throws Exception {
		//given
		int quantity = 5;

		//when
		LottoProfit profit = LottoProfit.of(quantity, true);

		//then
		assertThat(profit).isEqualTo(LottoProfit.FIVE_BONUS);

	}

}