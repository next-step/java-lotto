package automaticLotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_MINIMUM_NUMBER = 1;
	public static final int LOTTO_MAXIMUM_NUMBER = 45;
	public static final int LOTTO_LENGTH = 6;

	private List<Integer> numbers;
	private int bonusNumber;

	public Lotto(List<Integer> numberList) {
		this(numberList, 0);
	}

	public Lotto(List<Integer> numberList, int bonusNumber) {
		validateNumberListSize(new HashSet<>(numberList));
		validateBonusNumber(numberList, bonusNumber);

		this.numbers = numberList;
		this.bonusNumber = bonusNumber;
		sortLottoNumber();
	}

	private void validateBonusNumber(List<Integer> numberList, int bonusNumber) {
		if (numberList.contains(bonusNumber)) {
			throw new RuntimeException("bonus number can not be duplicated with lotto numbers");
		}
	}

	private void sortLottoNumber() {
		numbers.sort(Comparator.comparingInt(x -> x));
	}

	private void validateNumberListSize(Set<Integer> lotto) {
		if (lotto.size() != LOTTO_LENGTH) {
			throw new RuntimeException("lotto numbers must be consist of six numbers");
		}
	}

	public Ranking match(Lotto targetLotto) {
		int matchedCount = 0;
		boolean isBonusNumberContained = false;

		for (Integer number : targetLotto.numbers) {
			matchedCount = getMatchedCount(matchedCount, number);
		}

		if (numbers.contains(targetLotto.bonusNumber)) {
			isBonusNumberContained = true;
		}

		return Ranking.valueOf(new RankingCondition(matchedCount, isBonusNumberContained));
	}

	private int getMatchedCount(int matchedSize, Integer number) {
		if (numbers.contains(number)) {
			matchedSize++;
		}

		return matchedSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(numbers, lotto1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public String toString() {
		return numbers + "";
	}
}
