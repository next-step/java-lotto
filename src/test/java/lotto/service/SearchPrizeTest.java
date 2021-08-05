package lotto.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinPrizes;

class SearchPrizeTest {

	@Test
	@DisplayName("로또게임별 내용에따라 당첨번호를 입력하면 일치개수를 나타난다.")
	public void getMatchLottoGames() {
		List<Lotto> lottoGame = new ArrayList<>();
		lottoGame.add(new Lotto(getLottoNumbers(1, 3, 5, 10, 12, 21)));
		lottoGame.add(new Lotto(getLottoNumbers(1, 3, 5, 7, 12, 34)));
		WinPrizes winPrizes = SearchPrize.confirmWinLottoNumber(lottoGame, "1,3,5,7,9,17");

		assertThat(winPrizes.winPrizeSize()).isEqualTo(5);
		assertThat(winPrizes.searchWinPrizeGrade(Prize.FIFTH)).isEqualTo(1);
		assertThat(winPrizes.searchWinPrizeGrade(Prize.FOURTH)).isEqualTo(1);
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

		WinPrizes result = SearchPrize.confirmWinLottoNumber(lotto, "1,2,3,4,5,6");

		assertThat(result.searchWinPrizeGrade(Prize.THIRD)).isEqualTo(2);
		assertThat(result.searchWinPrizeGrade(Prize.FIRST)).isEqualTo(1);
	}

	@Test
	@DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
	public void validNumberTypeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			SearchPrize.confirmWinLottoNumber(new ArrayList<>(), "1,@,3,4,!,6")
		);
	}

	@Test
	@DisplayName("입력값이 반값이면 예외가 발생한다.")
	public void validEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			SearchPrize.confirmWinLottoNumber(new ArrayList<>(), "")
		);
	}

	@Test
	@DisplayName("로또의 볼은 6개가 아니면 예외가 발생한다.")
	public void validLottoSizeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			SearchPrize.confirmWinLottoNumber(new ArrayList<>(), "1,2,3")
		);
	}

	@Test
	@DisplayName("중복된 당첨번호가 존재하면 예외가 발생된다.")
	public void validDuplicateNumberCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			SearchPrize.confirmWinLottoNumber(new ArrayList<>(), "1,1,2,3,4,5")
		);
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