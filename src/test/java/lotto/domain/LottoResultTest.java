package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	@Test
	void isEqualTest() {
		Map<LottoRank, Integer> rankMap = Arrays.stream(LottoRank.values())
				.collect(Collectors.toMap(Function.identity(), rank -> 1));

		assertThat(new LottoResult(rankMap))
				.isEqualTo(new LottoResult(rankMap));
	}

	@Test
	void getWinningMap() {
		Map<LottoRank, Integer> rankMap = Arrays.stream(LottoRank.values())
				.collect(Collectors.toMap(Function.identity(), rank -> 1));

		assertThat(new LottoResult(rankMap).getWinningMap())
				.isEqualTo(rankMap);
	}

}