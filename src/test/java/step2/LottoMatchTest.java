package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;
import step2.model.LottoMatcher;

public class LottoMatchTest {

	@Test
	@DisplayName("일치하는 로또 개수 구한다")
	void winner() {
		List<Integer> winNum = Arrays.asList(1,2,3,4,5,6);
		LottoMatcher lotteryWin = new LottoMatcher(winNum);
		Assertions.assertThat(lotteryWin.isMatch(new Lotto(new FixLottoFactory()))).isEqualTo(2);
	}


}
