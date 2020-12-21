package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningLottoTicketTest {

	@DisplayName("1. 당첨 번호는 빈 값을 입력할 수 없다.")
	@ParameterizedTest
	@NullAndEmptySource
	public void inputCannotNullOrEmpty(String arg) {
		int bonusNumber = 5;
		assertThatThrownBy(() -> {
			WinningLottoTicket winningLottoTicket = new WinningLottoTicket(arg, new LottoNumber(bonusNumber));
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("지난 주 당첨 번호를 입력해 주세요.");
	}

	@DisplayName("2. 보너스번호 당첨번호를 입력한다.")
	@Test
	public void inputWinningNumberAndBonusNumber() {
		String winningNumber = "1,2,3,4,5,6";
		int bonusNumber = 10;
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumber, new LottoNumber(bonusNumber));
		assertThat(winningLottoTicket.getBonusNumber()).isEqualTo(new LottoNumber(bonusNumber));
	}
}
