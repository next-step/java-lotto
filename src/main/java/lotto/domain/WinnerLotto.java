package lotto.domain;

import java.util.List;

public class WinnerLotto {
	private Lotto lotto;
	private LottoNumber bonusNumber;

	public WinnerLotto(List<Integer> numberList, int bonusNumber) {
		validateBonusNumber(numberList, bonusNumber);
		this.lotto = new Lotto(numberList);
		this.bonusNumber = LottoNumber.of(bonusNumber);
	}

	private void validateBonusNumber(List<Integer> numberList, int bonusNumber) {
		if (numberList.contains(bonusNumber)) {
			throw new RuntimeException("bonus number can not be duplicated with lotto numbers");
		}
	}

	public Ranking match(Lotto boughtLotto) {
		return Ranking.valueOf(new RankingCondition(boughtLotto.match(lotto), boughtLotto.hasNumber(bonusNumber)));
	}
}
