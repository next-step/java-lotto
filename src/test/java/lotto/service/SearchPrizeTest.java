package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoGame;
import lotto.model.Prize;

class SearchPrizeTest {

	private SearchPrize searchPrize;

	@BeforeEach
	void setup(){
		searchPrize = new SearchPrize();
	}
	@Test
	@DisplayName("로또게임별 내용에따라 당첨번호를 입력하면 일치개수를 나타난다.")
	public void getMatchLottoGames() {
		List<Integer> lastWinNumbers = getLottoNumbers(1, 3, 5, 7, 9);

		List<LottoGame> lottoGames = new ArrayList<>();
		lottoGames.add(new LottoGame(getLottoNumbers(1, 3, 5, 10, 12)));
		lottoGames.add(new LottoGame(getLottoNumbers(1, 3, 5, 7, 12)));
		Map<Prize, Integer> result = searchPrize.drawWinPrize(lottoGames,lastWinNumbers);

		assertThat(result.size()).isEqualTo(5);
		assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
		assertThat(result.get(Prize.FOURTH)).isEqualTo(1);
	}

	@Test
	@DisplayName("로또게임시 결과값을 반환한다.")
	public void resultLottoStatus() {
		List<LottoGame> lottoGame = new ArrayList<>();
		lottoGame.add(getLottoGame(1, 2, 3, 4, 5, 7));
		lottoGame.add(getLottoGame(1, 2, 3, 4, 5, 9));
		lottoGame.add(getLottoGame(1, 2, 3, 4, 5, 6));
		lottoGame.add(getLottoGame(7, 9, 15, 21, 28, 39));
		lottoGame.add(getLottoGame(2, 2, 3, 32, 38, 45));

		Map<Prize, Integer> result = searchPrize.confirmWinLottoNumber(lottoGame,"1,2,3,4,5,6");

		assertThat(result.get(Prize.THIRD)).isEqualTo(2);
		assertThat(result.get(Prize.FIRST)).isEqualTo(1);

	}

	private LottoGame getLottoGame(int value1, int value2, int value3, int value4, int value5, int value6) {
		List<Integer> lottoNumber = new ArrayList<>();
		lottoNumber.add(value1);
		lottoNumber.add(value2);
		lottoNumber.add(value3);
		lottoNumber.add(value4);
		lottoNumber.add(value5);
		lottoNumber.add(value6);
		return new LottoGame(lottoNumber);
	}

	private List<Integer> getLottoNumbers(Integer... numbers) {
		List<Integer> lottoNumbers = new ArrayList<>();
		Collections.addAll(lottoNumbers, numbers);
		return lottoNumbers;
	}
}