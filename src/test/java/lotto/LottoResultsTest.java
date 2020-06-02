package lotto;

import lotto.domain.LottoResults;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

	@DisplayName("등수의 개수를 조회한다")
	@Test
	void getCounts() {
		Map<Rank, Long> map = new HashMap<>();
		map.put(Rank.FIRST, 2L);
		LottoResults results = new LottoResults(map);

		long counts = results.getCounts(Rank.FIRST);
		assertThat(counts).isEqualTo(2L);
	}

	@DisplayName("등수의 개수가 없으면 0을 리턴한다")
	@Test
	void getCounts_defaultIs0() {
		Map<Rank, Long> map = new HashMap<>();
		map.put(Rank.FIRST, 2L);
		LottoResults results = new LottoResults(map);

		long counts = results.getCounts(Rank.SECOND);
		assertThat(counts).isEqualTo(0);
	}

	@DisplayName("수익률을 계산한다")
	@Test
	void getProfitRate() {
		Map<Rank, Long> map = new HashMap<>();
		map.put(Rank.FIFTH, 1L);
		map.put(Rank.LOSING, 9L);
		LottoResults results = new LottoResults(map);

		float profitRate = results.getProfitRate();
		assertThat(profitRate).isEqualTo(0.5f);
	}
}
