package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.exception.InvalidBonusNumberException;

class WinningLottoTicketTest {

	@DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
	@Test
	void invalidBonusNumber() {
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		int bonusNumber = 6;
		assertThatThrownBy(() -> WinningLottoTicket.from(winningLottoNumbers, bonusNumber))
			.isInstanceOf(InvalidBonusNumberException.class);
	}

	@DisplayName("로또 당첨 티켓과 구매한 로또 티켓을 비교하여 당첨 결과를 확인한다.")
	@MethodSource("lottoTicketMatchArguments")
	@ParameterizedTest
	void match(WinningLottoTicket winningLottoTicket, LottoTicket boughtLottoTicket, LottoPrize expectedLottoPrize) {
		assertThat(winningLottoTicket.match(boughtLottoTicket)).isEqualTo(expectedLottoPrize);
	}

	private static Stream<Arguments> lottoTicketMatchArguments() {
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = WinningLottoTicket.from(winningLottoNumbers, 7);

		return Stream.of(
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoPrize.FIRST),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoPrize.SECOND),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 8)), LottoPrize.THIRD),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 3, 4, 8, 9)), LottoPrize.FOURTH),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 3, 8, 9, 10)), LottoPrize.FIFTH),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 2, 8, 9, 10, 11)), LottoPrize.NONE),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(1, 8, 9, 10, 11, 12)), LottoPrize.NONE),
			Arguments.of(winningLottoTicket, LottoTicket.from(Arrays.asList(8, 9, 10, 11, 12, 13)), LottoPrize.NONE)
		);
	}

}