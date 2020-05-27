package lotto;

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
		map.put(Rank.First, 2L);
		LottoResults results = new LottoResults(map);

		long counts = results.getCounts(Rank.First);
		assertThat(counts).isEqualTo(2L);
	}

	@DisplayName("등수의 개수가 없으면 0을 리턴한다")
	@Test
	void getCounts_defaultIs0() {
		Map<Rank, Long> map = new HashMap<>();
		map.put(Rank.First, 2L);
		LottoResults results = new LottoResults(map);

		long counts = results.getCounts(Rank.Second);
		assertThat(counts).isEqualTo(0);
	}
}