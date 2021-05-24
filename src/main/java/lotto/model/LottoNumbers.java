package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
	static final int LENGTH = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<Integer> inputNumbers) {
		validateLength(inputNumbers);
		validateDuplicate(inputNumbers);
		this.lottoNumbers = mapToLottoNumbers(inputNumbers);
	}

	static LottoNumbers of(Integer... numbers) {
		return new LottoNumbers(Arrays.asList(numbers));
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> lottoNumbers = new HashSet<>(numbers);
		validateLength(lottoNumbers);
	}

	private void validateLength(Collection<Integer> numbers) {
		if (numbers.size() != LENGTH) {
			throw new IllegalArgumentException("로또 번호는 서로 다른 6자리 숫자로 이루어져야 합니다.");
		}
	}

	private List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
			.map(LottoNumber::of)
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	List<Integer> getNumbers() {
		return lottoNumbers.stream()
			.map(LottoNumber::getNumber)
			.collect(toList());
	}

	LottoRank match(WinningNumbers winningNumbers) {
		LottoNumbers otherNumbers = winningNumbers.getLottoNumbers();
		LottoNumber bonusNumber = winningNumbers.getBonusNumber();
		return LottoRank.of(countOfMatch(otherNumbers), contains(bonusNumber));
	}

	int countOfMatch(LottoNumbers otherNumbers) {
		long matchCount = lottoNumbers.stream()
			.filter(otherNumbers::contains)
			.count();
		return Math.toIntExact(matchCount);
	}

	boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		LottoNumbers that = (LottoNumbers)other;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
