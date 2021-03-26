package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Ranking;
import lotto.domain.RateOfReturn;

public class RateOfReturnTest {

	@Test
	@DisplayName("수익률 테스트")
	void RorTest() {
		Map<Ranking, Integer> result = new HashMap<>();
		result.put(Ranking.THREE, 1);

		RateOfReturn rateOfReturn = new RateOfReturn();
		assertThat(rateOfReturn.calculate(result, 14000)).isEqualTo(0.35);
		assertThat(rateOfReturn.calculate(result, 15000)).isEqualTo(0.33);
		assertThat(rateOfReturn.calculate(result, 5000)).isEqualTo(1.00);
		assertThat(rateOfReturn.calculate(result, 1000)).isEqualTo(5.00);

	}
}
