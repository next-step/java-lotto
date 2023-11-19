package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoRankTest {

	@Test
	void draw_winning() {
		assertThat(LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(10, 11, 12, 13, 14, 15)))
				.isEqualTo(LottoRank.BLANK);
		assertThat(LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9)))
				.isEqualTo(LottoRank.FOURTH);
		assertThat(LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 8, 9)))
				.isEqualTo(LottoRank.THIRD);
		assertThat(LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 9)))
				.isEqualTo(LottoRank.SECOND);
		assertThat(LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6)))
				.isEqualTo(LottoRank.FIRST);
	}
}