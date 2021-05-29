package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTableTest {
	@Test
	@DisplayName("총 당첨 금액 계산")
	public void calculate_profit_rate() {
		WinnerTable winnerTable = new WinnerTable();
		winnerTable.count(Ranking.RANKING_4);

		assertThat(winnerTable.getTotalAmount()).isEqualTo(500000);
	}

	@Test
	@DisplayName("일치하는 숫자를 입력하면 카운트가 올라감")
	public void send_matched_count_return_plus_count() {
		WinnerTable winnerTable = new WinnerTable();

		winnerTable.count(Ranking.RANKING_3);
		assertThat(winnerTable.getWinnerCount(Ranking.RANKING_3)).isEqualTo(1);
	}
}
