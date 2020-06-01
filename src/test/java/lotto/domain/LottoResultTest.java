package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.collections.LottoResult;

public class LottoResultTest {

	@DisplayName("로또 구매에 대한 수익률을 계산해준다.")
	@CsvSource({"11, 0.45", "15, 0.33", "20, 0.25"})
	@ParameterizedTest
	void 구매액을_기준으로_수익률을_반환한다(int lottoTicketSize, double expected) {
		//given
		Map<Integer, Integer> lottoStatistics = new HashMap<>();
		lottoStatistics.put(2, 0);
		lottoStatistics.put(3, 1);
		LottoResult lottoResult = new LottoResult(lottoStatistics);

		//then
		assertThat(lottoResult.getLottoProfitRate(lottoTicketSize)).isEqualTo(expected);
	}
}
