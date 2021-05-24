package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTableTest {
	@Test
	@DisplayName("당첨 됐을 경우 해당 횟수 노출")
	public void present_winner_statics() {
		WinnerTable winnerTable = new WinnerTable() {
			@Override
			public void count(int matchedCount) {
				winnerTable.put(3, 4);
				winnerTable.put(4, 1);
			}
		};

		winnerTable.count(1);

		assertThat(winnerTable.getWinnerCount(3)).isEqualTo(4);
	}

	@Test
	@DisplayName("총 당첨 금액 계산")
	public void calculate_profit_rate() {
		WinnerTable winnerTable = new WinnerTable() {
			@Override
			public void count(int matchedCount) {
				winnerTable.put(3, 4);
				winnerTable.put(4, 1);
			}
		};

		winnerTable.count(1);

		assertThat(winnerTable.getTotalAmount()).isEqualTo(520000);
	}

	@Test
	@DisplayName("일치하는 숫자를 입력하면 카운트가 올라감")
	public void send_matched_count_return_plus_count() {
		WinnerTable winnerTable = new WinnerTable();

		winnerTable.count(3);
		assertThat(winnerTable.getWinnerCount(3)).isEqualTo(1);
	}

	@Test
	@DisplayName("일치하는 숫자가 3 미만 6초과이면 0 리턴")
	public void send_matched_count_that_is_under_3_or_over_6_return_0() {
		WinnerTable winnerTable = new WinnerTable();

		winnerTable.count(1);
		assertThat(winnerTable.getWinnerCount(1)).isEqualTo(0);
		winnerTable.count(7);
		assertThat(winnerTable.getWinnerCount(7)).isEqualTo(0);
	}
}
