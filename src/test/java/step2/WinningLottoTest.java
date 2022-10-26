package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.IllegalNumberException;
import step2.model.WinningLotto;

public class WinningLottoTest {

	@Test
	@DisplayName("일치하는 로또 개수 구한다")
	void match_num() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		WinningLotto lotteryWin = WinningLotto.of(winNum, bonusNumber);

		assertThat(lotteryWin.countOfMatch(Arrays.asList(1, 2, 22, 33, 41, 45)))
			.isEqualTo(2);
	}

	@Test
	@DisplayName("보너스 번호와 일치하는지 구한다")
	void match_bonus() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		WinningLotto lotteryWin = WinningLotto.of(winNum, bonusNumber);

		assertThat(lotteryWin.isBonus(5, Arrays.asList(1, 2, 5, bonusNumber, 41, 45)))
			.isEqualTo(true);
	}

	@Test
	@DisplayName("보너스 번호와 당첨 번호는 같을 수 없다")
	void bonus_valid() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 6;
		assertThatThrownBy(() -> WinningLotto.of(winNum, bonusNumber))
			.isInstanceOf(IllegalNumberException.class);
	}
	}
