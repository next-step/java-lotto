package camp.nextcamp.edu.lotto.module;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoNumber;
import camp.nextcamp.edu.lotto.entity.WinningLotto;
import camp.nextcamp.edu.lotto.module.LottoScoreBoardModule;
import camp.nextcamp.edu.lotto.module.WinningScore;

public class LottoScoreBoardModuleTest {

	private static Set<LottoNumber> getMock(Integer... input) {
		return new HashSet<>(Arrays.asList(input).stream().map(LottoNumber::valueOf).collect(Collectors.toList()));
	}


	@DisplayName("getWinningScoreBoard 테스트")
	@Test
	void 세개_네개_맞추기() {
		// given
		List<Lotto> list = Arrays.asList(
			new Lotto(getMock(2, 3, 4, 7, 9, 10)),     // 6
			new Lotto(getMock(2, 3, 4, 7, 9, 11)),     // 5
			new Lotto(getMock(2, 3, 4, 7, 9, 22)),     // 5
			new Lotto(getMock(2, 3, 4, 5, 6, 7)),      // 4
			new Lotto(getMock(1, 2, 3, 4, 5, 6)),      // 3
			new Lotto(getMock(5, 6, 11, 12, 14, 15)),  // 2
			new Lotto(getMock(5, 8, 11, 12, 14, 15)),  // 1
			new Lotto(getMock(1, 8, 11, 12, 14, 15))   // 0
		);

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		Map<WinningScore, Long> countByWinningScore = lottoModule.getWinningScoreBoard(list,
			new WinningLotto(new Lotto(getMock(2, 3, 4, 7, 9, 10)), LottoNumber.valueOf(11))
		);

		// then

		assertAll(
			() -> assertThat(countByWinningScore.get(WinningScore.FIRST))
				.isEqualTo(1),
			() -> assertThat(countByWinningScore.get(WinningScore.SECOND))
				.isEqualTo(1),
			() -> assertThat(countByWinningScore.get(WinningScore.THIRD))
				.isEqualTo(1),
			() -> assertThat(countByWinningScore.get(WinningScore.FOURTH))
				.isEqualTo(1),
			() -> assertThat(countByWinningScore.get(WinningScore.FIFTH))
				.isEqualTo(1),
			() -> assertThat(countByWinningScore.get(WinningScore.NONE))
				.isEqualTo(3)
		);
	}

	@DisplayName("수익률 테스트")
	@Test
	void profit_test() {
		// given
		List<Lotto> list = Arrays.asList(
			new Lotto(getMock(1, 2, 3, 4, 5, 6)),      // 3
			new Lotto(getMock(5, 6, 11, 12, 14, 15)),  // 2
			new Lotto(getMock(5, 8, 11, 12, 14, 15)),  // 1
			new Lotto(getMock(1, 8, 11, 12, 14, 15))   // 0
		);

		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		Map<WinningScore, Long> countByWinningScore = lottoModule.getWinningScoreBoard(list,
			new WinningLotto(new Lotto(getMock(2, 3, 4, 7, 9, 10)), LottoNumber.valueOf(11))
		);

		// when
		double profit = lottoModule.getProfit(countByWinningScore, list.size() * 1000);

		// then
		assertThat(profit)
			.isEqualTo((double) 5000 / 4000);
	}
}
