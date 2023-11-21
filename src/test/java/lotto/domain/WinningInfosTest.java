package lotto.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningInfosTest {

	@DisplayName("당첨 금액의 총합을 구한다.")
	@Test
	void sum_amount_each_rank() {
		WinningInfos winningInfos = new WinningInfos(
			List.of(
				new WinningInfo(Rank.THIRD, 3), new WinningInfo(Rank.FOURTH, 4)
			)
		);
		Assertions.assertThat(winningInfos.sumAmountEachRank()).isEqualTo(6200000);
	}
}
