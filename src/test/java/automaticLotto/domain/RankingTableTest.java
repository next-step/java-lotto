package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTableTest {
	@Test
	@DisplayName("일치하는 숫자를 전달하면 해당하는 상금을 리턴함")
	public void send_matched_count_return_its_winner_price() {

		assertThat(Ranking.getWinnerPrice(3)).isEqualTo(Ranking.RANKING_4);
		assertThat(Ranking.getWinnerPrice(4)).isEqualTo(Ranking.RANKING_3);
	}
}
