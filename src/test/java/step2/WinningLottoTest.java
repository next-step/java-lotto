package step2;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.WinningLotto;

public class WinningLottoTest {

	@Test
	@DisplayName("일치하는 로또 개수 구한다")
	void match_num() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		WinningLotto lotteryWin = new WinningLotto(winNum);

		Assertions.assertThat(lotteryWin.countOfMatch(Arrays.asList(1, 2, 22, 33, 41, 45)))
			.isEqualTo(2);
	}

	@Test
	@DisplayName("보너스 번호와 일치하는지 구한다")
	void match_bonus(){
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		WinningLotto lotteryWin = new WinningLotto(winNum,bonusNumber);

		Assertions.assertThat(lotteryWin.isBonusNumber(Arrays.asList(1, 2, 22, 33, 41, 45)))
			.isEqualTo(true);
	}
}
