package automaticLotto.domain;

import java.util.List;

public class WinnerLotto {
	private Lotto lotto;
	private int bonusNumber;

	public WinnerLotto(List<Integer> numberList, int bonusNumber) {
		this.lotto = new Lotto(numberList);
		this.bonusNumber = bonusNumber;
		validateBonusNumber(numberList, bonusNumber);
	}

	private void validateBonusNumber(List<Integer> numberList, int bonusNumber) {
		if (numberList.contains(bonusNumber)) {
			throw new RuntimeException("bonus number can not be duplicated with lotto numbers");
		}
	}

	public Ranking match(Lotto boughtLotto) {
		int matchedCount = 0;
		boolean isBonusNumberContained = false;

		for (Integer number : boughtLotto.getNumbers()) {
			matchedCount = getMatchedCount(matchedCount, number);
		}

		if (boughtLotto.hasNumber(bonusNumber)) {
			isBonusNumberContained = true;
		}

		return Ranking.valueOf(new RankingCondition(matchedCount, isBonusNumberContained));
	}

	private int getMatchedCount(int matchedCount, Integer number) {
		if (lotto.hasNumber(number)) {
			matchedCount++;
		}
		return matchedCount;
	}
}
