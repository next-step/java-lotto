package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.model.WinnerLotto;

class SearchPrizeTest {

	@Test
	@DisplayName("로또게임별 내용에따라 당첨번호를 입력하면 일치개수를 나타난다.")
	public void getMatchLottoGames() {
		List<Lotto> lottoGame = new ArrayList<>();
		lottoGame.add(new Lotto(getLottoNumbers(1, 3, 5, 10, 12, 21)));
		lottoGame.add(new Lotto(getLottoNumbers(1, 3, 5, 7, 12, 34)));
		WinPrizes winPrizes = SearchPrize.drawWinPrize(new Lottos(lottoGame), new WinnerLotto("1,2,3,4,5,6"));

		assertThat(winPrizes.getWinPrizeSize()).isEqualTo(5);
		assertThat(winPrizes.findWinPrizeGrade(Prize.FIFTH)).isEqualTo(1);
		assertThat(winPrizes.findWinPrizeGrade(Prize.FOURTH)).isEqualTo(1);
	}

	@Test
	@DisplayName("로또게임시 결과값을 반환한다.")
	public void resultLottoStatus() {
		List<Lotto> lotto = new ArrayList<>();
		lotto.add(getLottoGame(1, 2, 3, 4, 5, 7));
		lotto.add(getLottoGame(1, 2, 3, 4, 5, 9));
		lotto.add(getLottoGame(1, 2, 3, 4, 5, 6));
		lotto.add(getLottoGame(7, 9, 15, 21, 28, 39));
		lotto.add(getLottoGame(2, 2, 3, 32, 38, 45));

		WinPrizes result = SearchPrize.drawWinPrize(new Lottos(lotto), new WinnerLotto("1,2,3,4,5,6"));

		assertThat(result.findWinPrizeGrade(Prize.THIRD)).isEqualTo(2);
		assertThat(result.findWinPrizeGrade(Prize.FIRST)).isEqualTo(1);
	}

	private Lotto getLottoGame(int value1, int value2, int value3, int value4, int value5, int value6) {
		List<Integer> lottoNumber = new ArrayList<>();
		lottoNumber.add(value1);
		lottoNumber.add(value2);
		lottoNumber.add(value3);
		lottoNumber.add(value4);
		lottoNumber.add(value5);
		lottoNumber.add(value6);
		return new Lotto(lottoNumber);
	}

	private List<Integer> getLottoNumbers(Integer... numbers) {
		List<Integer> lottoNumbers = new ArrayList<>();
		Collections.addAll(lottoNumbers, numbers);
		return lottoNumbers;
	}
}