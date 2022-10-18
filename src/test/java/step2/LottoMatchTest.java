package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchTest {

	@Test
	@DisplayName("일치하는 로또 번호를 구한다")
	void winner() {
		List<Integer> winNum = Arrays.asList(1,2,3,4,5,6);
		LottoMatch lotteryWin = new LottoMatch(winNum);

		assertThat(lotteryWin.match(new Lotto(new FixLottoFactory()))).contains(1,6);
	}

}
