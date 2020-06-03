package lotto.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoNumber;

public class WinningTicketTest {

	static Stream<Arguments> SIX_ELEMENTS_OF_WINNING_NUMBERS() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
			Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), 13)
		);
	}

	@DisplayName("지난 회차 승리 번호와 보너스 볼은 중복될 수 없다.")
	@MethodSource("SIX_ELEMENTS_OF_WINNING_NUMBERS")
	@ParameterizedTest
	void 승리_번호와_보너스_볼은_중복되지_않는다(List<Integer> winningNumberList, int bonusBall) {
		//given
		WinningNumbers winningNumbers = new WinningNumbers(winningNumberList);
		//when
		LottoNumber bonusBallNumber = new LottoNumber(bonusBall);
		//then
		assertThatThrownBy(
			() -> new WinningTicket(winningNumbers, bonusBallNumber))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("로또 번호와 보너스 볼은 중복 불가합니다.");
	}
}
