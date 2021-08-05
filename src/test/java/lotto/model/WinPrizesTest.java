package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinPrizesTest {

	@Test
	@DisplayName("로또 등수를입력하면 당첨내역중에 일치한 등수확인 가능하다.")
	public void searchWinPrizeGrade() {
		WinPrizes winPrizes = new WinPrizes(getWinPrize());
		int thirdWinners = winPrizes.searchWinPrizeGrade(Prize.FIFTH);

		assertThat(thirdWinners).isEqualTo(100);

		int fourthWinners = winPrizes.searchWinPrizeGrade(Prize.FOURTH);

		assertThat(fourthWinners).isEqualTo(20);

		int firstWinners = winPrizes.searchWinPrizeGrade(Prize.FIRST);

		assertThat(firstWinners).isEqualTo(2);
	}

	@Test
	@DisplayName("전체 당첨등급에 대해서 반환한다.")
	public void totalPrizeGradeNumber() {
		WinPrizes winPrizes = new WinPrizes(getWinPrize());
		int prizeGradeNumber = winPrizes.winPrizeSize();

		assertThat(prizeGradeNumber).isEqualTo(5);
	}

	@Test
	@DisplayName("전체 당첨금의 금액을 알수 있다.")
	public void getTotalMoney() {
		WinPrizes winPrizes = new WinPrizes(getWinPrizeTotalMoney());
		int getTotalMoney = winPrizes.getTotalWinningMoney();

		assertThat(getTotalMoney).isEqualTo(25000);
	}

	@Test
	@DisplayName("당첨에 대한 정보를 알수있다.")
	public void resultWinPrize(){
		WinPrizes winPrizes = new WinPrizes(getWinPrizeTotalMoney());
		List<Prize> prizes = winPrizes.resultWinPrizes();

		assertThat(prizes.size()).isEqualTo(5);
		assertThat(winPrizes.searchWinPrizeGrade(prizes.get(1))).isEqualTo(5);
	}

	private Map<Prize, Integer> getWinPrize() {
		Map<Prize, Integer> getWinPrize = new HashMap<>();
		getWinPrize.put(Prize.MISS, 200);
		getWinPrize.put(Prize.FIFTH, 100);
		getWinPrize.put(Prize.FOURTH, 20);
		getWinPrize.put(Prize.THIRD, 10);
		getWinPrize.put(Prize.FIRST, 2);
		return getWinPrize;
	}

	private Map<Prize, Integer> getWinPrizeTotalMoney() {
		Map<Prize, Integer> getWinPrize = new HashMap<>();
		getWinPrize.put(Prize.MISS, 0);
		getWinPrize.put(Prize.FIFTH, 5);
		getWinPrize.put(Prize.FOURTH, 0);
		getWinPrize.put(Prize.THIRD, 0);
		getWinPrize.put(Prize.FIRST, 0);
		return getWinPrize;
	}

}