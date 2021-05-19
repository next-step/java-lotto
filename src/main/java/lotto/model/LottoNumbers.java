package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
	static final int LENGTH = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<Integer> inputNumbers) {
		validateLength(inputNumbers);
		validateDuplicate(inputNumbers);
		this.lottoNumbers = Collections.unmodifiableList(mapToLottoNumbers(inputNumbers));
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
			.map(LottoNumber::new)
			.collect(toList());
	}

	List<Integer> getNumbers() {
		return lottoNumbers.stream()
			.map(LottoNumber::getNumber)
			.collect(toList());
	}

	int match(LottoNumbers otherNumbers) {
		long matchCount = lottoNumbers.stream()
			.filter(otherNumbers::contains)
			.count();
		return Math.toIntExact(matchCount);
	}

	private boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}
