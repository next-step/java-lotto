package step4.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
	@Test
	void 순위비교() {
		assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
		assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
		assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
		assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
		assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
		assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
	}
}
