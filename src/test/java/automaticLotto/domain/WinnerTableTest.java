package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTableTest {
	private Map<Integer, Integer> winnerTableMap;

	@BeforeEach
	void setUp() {
		winnerTableMap = new HashMap<>();
		winnerTableMap.put(3, 4);
		winnerTableMap.put(4, 1);

	}

	@Test
	@DisplayName("당첨 됐을 경우 해당 횟수 노출")
	public void present_winner_statics() {
		WinnerTable winnerTable = new WinnerTable(winnerTableMap);

		assertThat(winnerTable.getWinnerCount(3)).isEqualTo(4);
	}

	@Test
	@DisplayName("총 당첨 금액 계산")
	public void calculate_profit_rate() {
		WinnerTable winnerTable = new WinnerTable(winnerTableMap);

		assertThat(winnerTable.getTotalAmount()).isEqualTo(520000);
	}
}
