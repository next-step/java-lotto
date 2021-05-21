package lotto.domain;

import java.util.*;

public class LottoNumbers {

	public static final int LOTTO_NUMBER_LENGTH = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public LottoNumbers(List<Integer> numbers) {
		validationNumbers(numbers);
		lottoNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}
	}

	public LottoNumbers(RandomNumbersGenerator randomNumbersGenerator) {
		this(randomNumbersGenerator.generateNumbers());
	}

	private void validationNumbers(List<Integer> numbers) {
		validationSize(numbers);
		validationDuplicate(numbers);
	}

	private void validationDuplicate(List<Integer> numbers) {
		if (removeDuplicateNumbers(numbers).size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("로또번호중에서 중복된 숫자가 포함되어 있습니다.");
		}
	}

	private void validationSize(List<Integer> numbers) {
		if (numbers == null || numbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("로또는 숫자6개로 이루어져야 합니다.");
		}
	}

	public List<Integer> removeDuplicateNumbers(List<Integer> numbers) {
		Set<Integer> set = new LinkedHashSet<>();
		for (Integer number : numbers) {
			set.add(number);
		}
		return new ArrayList<>(set);
	}

	public boolean hasSize(int size) {
		return this.lottoNumbers.size() == size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumbers that = (LottoNumbers) o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
