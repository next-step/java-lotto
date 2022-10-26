package step2.model;

import java.util.List;
import java.util.function.Predicate;
import step2.exception.IllegalNumberException;

public class WinningLotto {

	private static final int SECOND_MATCH_NUM = 5;
	private List<Integer> winLottoNumber;
	private int bonusNumber;


	private WinningLotto(List<Integer> winLottoNumber, int bonusNumber) {
		this.winLottoNumber = winLottoNumber;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto of(List<Integer> winLottoNumber, int bonusNumber) {
		if (winLottoNumber.stream()
			.anyMatch(Predicate.isEqual(bonusNumber))) {
			throw new IllegalNumberException("보너스 번호는 당첨 번호랑 같을 수 없습니다.");
		}
		return new WinningLotto(winLottoNumber, bonusNumber);
	}


	public int countOfMatch(List<Integer> lotto) {
		return (int) winLottoNumber.stream()
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
