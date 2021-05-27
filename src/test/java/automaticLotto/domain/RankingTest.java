package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {
	@Test
	@DisplayName("매치되는 수를 넘겨주면 해당 하는 랭킹 값을 반환")
	public void send_matched_count_return_ranking() {
		assertThat(Ranking.valueOf(new RankingCondition(3, false))).isEqualTo(Ranking.RANKING_5);
		assertThat(Ranking.valueOf(new RankingCondition(3, true))).isEqualTo(Ranking.RANKING_5);
	}

	@Test
	@DisplayName("매치되는 수가 5이고 보너스 값이 존재하면 랭킹 2위, 없으면 랭킹 3위")
	public void get_the_size_of_lottos() {
		assertThat(Ranking.valueOf(new RankingCondition(5, false))).isEqualTo(Ranking.RANKING_3);
		assertThat(Ranking.valueOf(new RankingCondition(5, true))).isEqualTo(Ranking.RANKING_2);
	}

	@Test
	@DisplayName("매치되는 수의 최소값과 최대값을 구함")
	public void get_maximum_match_count_and_minimum_match_count() {
		assertThat(Ranking.getMaximumMatchedCount()).isEqualTo(6);
		assertThat(Ranking.getMinimumMatchedCount()).isEqualTo(0);
	}

}
