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

	public Lotto(List<Integer> numberList) {
		validateNumberListSize(new HashSet<>(numberList));

		this.numbers = numberList;
		sortLottoNumber();
	}

	private void sortLottoNumber() {
		numbers.sort(Comparator.comparingInt(x -> x));
	}

	private void validateNumberListSize(Set<Integer> lotto) {
		if (lotto.size() != LOTTO_LENGTH) {
			throw new RuntimeException("lotto numbers must be consist of six numbers");
		}
	}

	public boolean hasNumber(int number) {
		return numbers.contains(number);
	}

	public List<Integer> getNumbers() {
		return numbers;
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
