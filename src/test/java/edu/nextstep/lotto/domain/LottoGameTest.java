package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoGame: 구입한 lotto목록이나 당첨번호를 필드로, 당첨통계나 수익률을 계산함.")
class LottoGameTest {
	@DisplayName("생성자: LottoGame 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		List<List<Integer>> lottoNumbers = Arrays.asList(
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6)
		);
		List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoGame lottoGame = new LottoGame(lottoNumbers, winningLottoNumber);
		assertThat(lottoGame)
			.isNotNull()
			.isInstanceOf(LottoGame.class)
			.hasNoNullFieldsOrPropertiesExcept("soldLottos", "winningLotto");
	}

	@DisplayName("getResultAsCountingMap: 1,3,4,5등이 각각 몇 개 씩 당첨되었는지 취합하여 map으로 리턴함.")
	@Test
	void getResultAsCountingMap() {
		List<List<Integer>> lottoNumbers = Arrays.asList(
			// 1등.
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),

			// 3등.
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),

			// 4등.
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),

			// 5등.
			Arrays.asList(1, 2, 3, 7, 8, 9),

			Arrays.asList(1, 2, 7, 8, 9, 10)
		);
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		LottoGame lottoGame = new LottoGame(lottoNumbers, winningNumbers);
		assertThat(lottoGame.getResultAsCountingMap())
			.extractingByKeys(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH)
			.containsExactly(3L, 3L, 5L, 1L);
	}
}