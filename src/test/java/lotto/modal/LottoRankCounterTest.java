package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class LottoRankCounterTest {

	@Test
	void initLottoRankCountersTest() {

		List<LottoRankCounter> counters = Arrays.stream(LottoRank.values())
			.map(LottoRankCounter::new)
			.collect(Collectors.toList());

		assertThat(counters.size()).isEqualTo(LottoRank.values().length);

		System.out.println(LottoRank.NOTHING_RANK.ordinal());
		System.out.println(LottoRank.FOURTH_RANK.ordinal());
		System.out.println(LottoRank.THIRD_RANK.ordinal());
		System.out.println(LottoRank.SECOND_RANK.ordinal());
		System.out.println(LottoRank.FIRST_RANK.ordinal());
	}

	@Test
	void initLottoRankCounterTest() {

		LottoRankCounter counter = new LottoRankCounter(LottoRank.FIRST_RANK);

		assertThat(counter).isEqualTo(new LottoRankCounter(LottoRank.FIRST_RANK));
	}
}
