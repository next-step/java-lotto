package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	private Map<LottoRank, Integer> rankMap = Arrays.stream(LottoRank.values())
			.collect(Collectors.toMap(Function.identity(), rank -> 1));
	private int buyPrize = 14000;

	private LottoResult lottoResult = new LottoResult(rankMap, buyPrize);

	@Test
	void isEqualTest() {
		assertThat(lottoResult)
				.isEqualTo(new LottoResult(rankMap, buyPrize));
	}

	@Test
	void getWinningMapTest() {
		assertThat(new LottoResult(rankMap, buyPrize).getWinningMap())
				.isEqualTo(rankMap);
	}

	@Test
	void getYieldTest() {
		int earnedPrize = rankMap
				.entrySet()
				.stream()
				.mapToInt(entry -> entry.getKey().getEarningPrize() * entry.getValue())
				.sum();
		assertThat(lottoResult.getYield())
				.isEqualTo((double) earnedPrize / buyPrize);
	}

}