package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingConditionTest {
	@Test
	@DisplayName("매치된 수가 5가 아니면 매치된 수로만 랭킹 계산")
	public void when_match_count_is_under_5_then_only_match_count_is_matter_for_calculating_ranking() {
		assertThat(new RankingCondition(3, true)).isEqualTo(new RankingCondition(3, false));
		assertThat(Ranking.valueOf(new RankingCondition(3, true))).isEqualTo(Ranking.RANKING_5);
	}

	@Test
	@DisplayName("매치된 수가 5면 매치된 수와 보너스 수 존재 여부로 랭킹 계산")
	public void when_match_count_is_5_then_match_count_and_bonus_number_are_matter_for_calculating_ranking() {
		assertThat(Ranking.valueOf(new RankingCondition(5, false))).isEqualTo(Ranking.RANKING_3);
		assertThat(Ranking.valueOf(new RankingCondition(5, true))).isEqualTo(Ranking.RANKING_2);
	}
}
