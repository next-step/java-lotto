package lotto.domain;

import static java.util.Arrays.asList;
import static lotto.enums.Prize.FIRST;
import static lotto.enums.Prize.SECOND;
import static lotto.enums.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.Prize;
import org.junit.Test;

public class WinningResultTest {

	@Test
	public void 상금_개수_검증() {
		List<Prize> prizes = asList(THIRD, THIRD, SECOND, FIRST);
		WinningResult winningResult = new WinningResult(prizes);

		assertThat(winningResult.getPrizeCount(THIRD)).isEqualTo(2);
	}
}