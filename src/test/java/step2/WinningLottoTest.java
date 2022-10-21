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

		Assertions.assertThat(lotteryWin.countMatch(Arrays.asList(1, 2, 22, 33, 41, 45)))
			.isEqualTo(2);
	}

}
