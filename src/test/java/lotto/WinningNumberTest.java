package lotto;

import static lotto.Winner.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
	@Test
	@DisplayName("보너스볼이 중복될 경우 예외 발생")
	void bonusBallDuplicateCheck() {
		Lotto winLotto = new Lotto("1,2,3,4,5,6");
		LottoNumber bonusNumber = LottoNumber.valueOf("1");
		assertThatThrownBy(() -> new WinningNumber(winLotto, bonusNumber))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("당첨번호로부터 등수 확인")
	void matchWinningNumber() {
		Lotto lotto1st = new Lotto("1,2,3,4,5,6");
		Lotto lotto2nd = new Lotto("2,3,4,5,6,7");
		Lotto lotto3rd = new Lotto("2,3,4,5,6,8");
		Lotto lotto4th = new Lotto("3,4,5,6,7,8");
		Lotto lotto5th = new Lotto("4,5,6,7,8,9");

		Lotto winLotto = new Lotto("1,2,3,4,5,6");
		LottoNumber bonusNumber = LottoNumber.valueOf("7");
		WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

		assertThat(winningNumber.matchResult(lotto1st)).isEqualTo(FIRST_PRIZE);
		assertThat(winningNumber.matchResult(lotto2nd)).isEqualTo(SECOND_PRIZE);
		assertThat(winningNumber.matchResult(lotto3rd)).isEqualTo(THIRD_PRIZE);
		assertThat(winningNumber.matchResult(lotto4th)).isEqualTo(FOURTH_PRIZE);
		assertThat(winningNumber.matchResult(lotto5th)).isEqualTo(FIFTH_PRIZE);
	}
}
