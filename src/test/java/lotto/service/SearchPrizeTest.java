package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoGame;
import lotto.model.LottoGames;
import lotto.model.Prize;

class SearchPrizeTest {

	@Test
	@DisplayName("로또게임별 내용에따라 당첨번호를 입력하면 일치개수를 나타난다.")
	public void getMatchLottoGames() {
		List<Integer> lastWinNumbers = getLottoNumbers(1, 3, 5, 7, 9);
		SearchPrize searchPrize = new SearchPrize();

		List<LottoGame> lottoGames = new ArrayList<>();
		lottoGames.add(new LottoGame(getLottoNumbers(1, 3, 5, 10, 12)));
		lottoGames.add(new LottoGame(getLottoNumbers(1, 3, 5, 7, 12)));
		LottoGames lottoGameResult = new LottoGames(lottoGames);
		Map<Prize, Integer> result = searchPrize.getWinPrizes(lottoGameResult, lastWinNumbers);

		assertThat(result.size()).isEqualTo(5);
		assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
		assertThat(result.get(Prize.FOURTH)).isEqualTo(1);
	}

	private List<Integer> getLottoNumbers(Integer... numbers) {
		List<Integer> lottoNumbers = new ArrayList<>();
		Collections.addAll(lottoNumbers, numbers);
		return lottoNumbers;
	}
}