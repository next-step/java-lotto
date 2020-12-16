package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.lotto.util.NumberUtil;

@DisplayName("LottoGame: 구입한 lotto목록이나 당첨번호를 필드로, 당첨통계나 수익률을 계산함.")
class LottoGameTest {
	private LottoGame lottoGame;

	@BeforeEach
	void beforeEach() {
		List<List<Integer>> lottoNumbers = new ArrayList<>();
		// 1등.
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));

		// 3등.
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 7));
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 7));

		// 4등.
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 7, 8));
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 7, 8));
		lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 7, 8));

		// 5등.
		lottoNumbers.add(Arrays.asList(1, 2, 3, 7, 8, 9));

		// 미당첨
		for (int i = 0; i < 10000; i++) {
			lottoNumbers.add(NumberUtil.generateSortedRandomNumber(7, 45, 6));
		}
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		lottoGame = new LottoGame(lottoNumbers, winningNumbers);
	}

	@DisplayName("생성자: LottoGame 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		assertThat(lottoGame)
			.isNotNull()
			.isInstanceOf(LottoGame.class)
			.hasNoNullFieldsOrPropertiesExcept("soldLottos", "winningLotto");
	}

	@DisplayName("getResultAsCountingMap: 1,3,4,5등이 각각 몇 개 씩 당첨되었는지 취합하여 map으로 리턴함.")
	@Test
	void getResultAsCountingMap() {
		assertThat(lottoGame.getResultAsCountingMap())
			.extractingByKeys(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH)
			.containsExactly(1L, 2L, 3L, 1L);
	}

	@DisplayName("getProfitRatio: '상금 / 구매비용'을 소수점 둘째자리까지 구하고 버림하여 리턴함.")
	@Test
	void getProfitRatio() {
		assertThat(lottoGame.getProfitRatio()).hasToString("200.17");
	}
}