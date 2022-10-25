package step2.model;

import java.util.List;

public class WinningLotto {

	private static final int SECOND_MATCH_NUM = 5;
	private List<Integer> winLotto;
	private int bonusNumber;


	private WinningLotto(List<Integer> winLotto, int bonusNumber) {
		this.winLotto = winLotto;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto of(List<Integer> winNumList, int bonusNumber) {
		return new WinningLotto(winNumList, bonusNumber);
	}

	public int countOfMatch(List<Integer> lotto) {
		return (int) winLotto.stream()
			.filter(lotto::contains)
			.count();
	}

	public boolean isBonus(int countLottoMatch, List<Integer> lotto) {
		long countOfBonus = 0;

		if (countLottoMatch == SECOND_MATCH_NUM) {
			countOfBonus = lotto.stream().filter(s -> s.equals(bonusNumber)).count();
		}

		if (countOfBonus > 0) {
			return true;
		}
		return false;
	}
}
