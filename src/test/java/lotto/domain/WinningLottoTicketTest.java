package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidBonusNumberException;

class WinningLottoTicketTest {

	@DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
	@Test
	void invalidBonusNumber() {
		List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 6;
		assertThatThrownBy(() -> WinningLottoTicket.from(lottoNumbers, bonusNumber))
			.isInstanceOf(InvalidBonusNumberException.class);
	}

	@DisplayName("로또 당첨 티켓과 구매한 로또 티켓을 비교하여 당첨 결과를 확인한다.")
	@Test
	void compareTo() {
		WinningLottoTicket winningLottoTicket = WinningLottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
		LottoTicket boughtLottoTicket = LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 7));
		LottoPrize lottoPrize = winningLottoTicket.match(boughtLottoTicket);
		assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
	}

}