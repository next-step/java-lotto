package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.lotto.domain.LottoGame;
import edu.nextstep.lotto.util.NumberUtil;

@DisplayName("LottoGameResult: 당첨결과나 수익률을 관리하는 클래스.")
class LottoGameResultTest {
	private LottoGameResult lottoGameResult;

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

		lottoGameResult = LottoGame.createOf(lottoNumbers, winningNumbers, 7).getResult();
	}

	@DisplayName("getResultAsCountingMap: 1,3,4,5등이 각각 몇 개 씩 당첨되었는지 취합하여 map으로 리턴함.")
	@Test
	void getResultAsCountingMap() {
		assertThat(lottoGameResult.getResultMap())
			.extractingByKeys(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH)
			.containsExactly(1L, 2L, 3L, 1L);
	}

	@DisplayName("getSoldLottoCount: 판매된 총 로또의 개수를 구함. lottoGameResultMap의 value를 모두 더해서 리턴함.")
	@Test
	void getSoldLottoCount() {
		assertThat(lottoGameResult.getSoldLottoCount()).isEqualTo(10007L);
	}

	@DisplayName("getProfitRatio: '상금 / 구매비용'을 소수점 둘째자리까지 구하고 버림하여 리턴함.")
	@Test
	void getProfitRatio() {
		assertThat(lottoGameResult.getProfitRatio()).hasToString("200.17");
	}
}