package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTicketTest {

	@DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
	@Test
	void invalidBonusNumber() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 6;
		assertThatThrownBy(() -> WinningLottoTicket.from(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

}