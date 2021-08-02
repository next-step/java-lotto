package lottoautomatic.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottoProfitTest {

	@Test
	@DisplayName("잘못된 일치 수를 입력하는 경우")
	void lotto_profit() throws Exception {
		//given
		int quantity = 7;

		//when
		ThrowingCallable newLottoProfit = () -> LottoProfit.from(quantity);

		//then
		assertThatThrownBy(newLottoProfit).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "당첨당 합산 금액 {index} [{arguments}]")
	@CsvSource(value = {
			"3,1,5000",
			"3,2,10000",
			"4,1,50000",
			"4,2,100000",
			"5,1,1500000",
			"5,2,3000000",
			"6,1,2000000000",
			"6,2,4000000000"
	})
	void profit_sum(int quantity, int matchingCount, long totalProfit) throws Exception {
		//given
		LottoProfit lottoProfit = LottoProfit.from(quantity);

		//when
		long profit = lottoProfit.profit(matchingCount);

		//then
		assertThat(profit).isEqualTo(totalProfit);
	}

}