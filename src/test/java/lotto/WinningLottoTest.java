package lotto;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
	@Test
	@DisplayName("보너스볼이 중복될 경우 예외 발생")
	void bonusBallDuplicateCheck() {
		Lotto winningNumber = LottoGenerator.generate("1,2,3,4,5,6");
		LottoNumber bonusBall = LottoNumber.valueOf("1");
		assertThatThrownBy(() -> new WinningLotto(winningNumber, bonusBall))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("당첨번호로부터 등수 확인")
	void matchWinningNumber() {
		Lotto lotto1st = LottoGenerator.generate("1,2,3,4,5,6");
		Lotto lotto2nd = LottoGenerator.generate("2,3,4,5,6,7");
		Lotto lotto3rd = LottoGenerator.generate("2,3,4,5,6,8");
		Lotto lotto4th = LottoGenerator.generate("3,4,5,6,7,8");
		Lotto lotto5th = LottoGenerator.generate("4,5,6,7,8,9");

		Lotto winningNumber = LottoGenerator.generate("1,2,3,4,5,6");
		LottoNumber bonusBall = LottoNumber.valueOf("7");
		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);

		assertThat(winningLotto.resultOf(lotto1st)).isEqualTo(FIRST);
		assertThat(winningLotto.resultOf(lotto2nd)).isEqualTo(SECOND);
		assertThat(winningLotto.resultOf(lotto3rd)).isEqualTo(THIRD);
		assertThat(winningLotto.resultOf(lotto4th)).isEqualTo(FOURTH);
		assertThat(winningLotto.resultOf(lotto5th)).isEqualTo(FIFTH);
	}
}
