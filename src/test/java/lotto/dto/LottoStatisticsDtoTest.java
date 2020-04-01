package lotto.dto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsDtoTest {

	private Map<LottoRank, Long> rankMap = Arrays.stream(LottoRank.values())
			.collect(Collectors.toMap(Function.identity(), rank -> 1L));
	private int spendMoney = 14000;

	private LottoStatisticsDto lottoStatisticsDto = new LottoStatisticsDto(rankMap, spendMoney);

	@Test
	void getWinningMapTest() {
		assertThat(new LottoStatisticsDto(rankMap, spendMoney).getWinningMap())
				.isEqualTo(rankMap);
	}

	@Test
	@DisplayName("0개인 것들도 모두 보여줘야 하기 때문에 result 결과 값에는 0인 맵이 나오는 지 확인하는 테스트")
	void getWinningMapZeroPaddingTest() {
		Map<LottoRank, Long> rankMap = Stream.of(LottoRank.FIRST)
				.collect(Collectors.toMap(Function.identity(), rank -> 0L));

		Map<LottoRank,Long> expectedMap = Arrays.stream(LottoRank.values())
				.collect(Collectors.toMap(Function.identity(), rank -> 0L));

		assertThat(new LottoStatisticsDto(rankMap, spendMoney).getWinningMap())
				.isEqualTo(expectedMap);
	}

	@Test
	void getYieldTest() {
		long winningMoney = rankMap
				.keySet()
				.stream()
				.mapToLong(LottoRank::getWinningMoney)
				.sum();
		assertThat(lottoStatisticsDto.getYield())
				.isEqualTo((double) winningMoney / spendMoney);
	}

}