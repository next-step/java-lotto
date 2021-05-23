package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoNumbers;
import lotto.store.Ticket;

public class StatisticsCalculatorTest {

	@Test
	@DisplayName(value = "일치 횟수당 통계를 계산한다")
	void statistics() {
		LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
		StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
		Map<Integer, Statistic> countByStatic = calculator.statistics();
		assertThat(countByStatic.get(3)).isEqualTo(new Statistic(1, Earn.THREE_MATCHED));
	}

	@Test
	@DisplayName(value = "이번 로또 게임으로 인해서 총 벌어들인 금액을 계산한다")
	void earningPrice() {
		LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
		StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
		assertThat(calculator.sumEarningPrice()).isEqualTo(5000 + 50000 + 1500000 + 2000000000);
	}

	private Ticket mockTicket() {
		List<LottoNumbers> purchased = new ArrayList() {{
			add(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
			add(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)));
			add(new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8)));
			add(new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9)));
		}};
		return new Ticket(purchased, 4000);
	}

}
