package lotto;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
	@Test
	@DisplayName("보너스볼이 중복될 경우 예외 발생")
	void bonusBallDuplicateCheck() {
		Lotto winLotto = LottoGenerator.customNumbers("1,2,3,4,5,6");
		LottoNumber bonusNumber = LottoNumber.valueOf("1");
		assertThatThrownBy(() -> new WinningLotto(winLotto, bonusNumber))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("당첨번호로부터 등수 확인")
	void matchWinningNumber() {
		Lotto lotto1st = LottoGenerator.customNumbers("1,2,3,4,5,6");
		Lotto lotto2nd = LottoGenerator.customNumbers("2,3,4,5,6,7");
		Lotto lotto3rd = LottoGenerator.customNumbers("2,3,4,5,6,8");
		Lotto lotto4th = LottoGenerator.customNumbers("3,4,5,6,7,8");
		Lotto lotto5th = LottoGenerator.customNumbers("4,5,6,7,8,9");

		Lotto winLotto = LottoGenerator.customNumbers("1,2,3,4,5,6");
		LottoNumber bonusNumber = LottoNumber.valueOf("7");
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusNumber);

		assertThat(winningLotto.resultOf(lotto1st)).isEqualTo(FIRST);
		assertThat(winningLotto.resultOf(lotto2nd)).isEqualTo(SECOND);
		assertThat(winningLotto.resultOf(lotto3rd)).isEqualTo(THIRD);
		assertThat(winningLotto.resultOf(lotto4th)).isEqualTo(FOURTH);
		assertThat(winningLotto.resultOf(lotto5th)).isEqualTo(FIFTH);
	}
}
