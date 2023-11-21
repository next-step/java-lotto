package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningInfoTest {

	@DisplayName("구매한 티켓의 총 당첨 금액을 계산한다.")
	@ParameterizedTest
	@MethodSource("rankAndTotalAmount")
	void calc_total_amount_by_all_ticket_return(WinningInfo winningInfo, long expected) {
		assertThat(winningInfo.calcTotalAmount()).isEqualTo(expected);
	}

	static Stream<Arguments> rankAndTotalAmount() {
		return Stream.of(
			Arguments.arguments(new WinningInfo(Rank.FOURTH, 4), Rank.FOURTH.getAmount() * 4),
			Arguments.arguments(new WinningInfo(Rank.THIRD, 6), Rank.THIRD.getAmount() * 6),
			Arguments.arguments(new WinningInfo(Rank.SECOND, 5), Rank.SECOND.getAmount() * 5),
			Arguments.arguments(new WinningInfo(Rank.FIRST, 2), Rank.FIRST.getAmount() * 2)
		);
	}
}
