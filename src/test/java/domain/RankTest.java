package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

	@DisplayName("보너스를 맞췄고 5개를 맞췄을 때")
	@Test
	void test_rank_bonus() {
		Rank rank = Rank.rank(5, true);
		assertThat(rank.getAmount()).isEqualTo(30_000_000);
	}

	@DisplayName("보너스를 맞추지 못했고 5개를 맞췄을 때")
	@Test
	void test_rank_no_bonus() {
		Rank rank = Rank.rank(5, false);
		assertThat(rank.getAmount()).isEqualTo(1_500_000);
	}
}
