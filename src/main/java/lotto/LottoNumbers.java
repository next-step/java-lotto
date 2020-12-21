package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
	private static final int LOTTO_NUMBER_SIZE = 6;

	private final Set<LottoNumber> lottoNumbers;

	private LottoNumbers(Set<LottoNumber> lottoNumbers) {
		validateSize(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
	}

	private static void validateSize(Collection<?> lottoNumbers) {
		if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException("로또 숫자가 없습니다.");
		}
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 숫자는 6개입니다.");
		}
	}

	public static LottoNumbers of(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);

		return numbers.stream()
			.map(LottoNumber::of)
			.collect(collectingAndThen(toSet(), LottoNumbers::new));
	}

	private static void validateDuplicate(List<Integer> lottoNumbers) {
		if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public static LottoNumbers createRandom() {
		return new LottoNumbers(extractNumbers());
	}

	private static Set<LottoNumber> extractNumbers() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		while (lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
			lottoNumbers.add(LottoNumber.createRandom());
		}
		return lottoNumbers;
	}

	public boolean isSameNumbers(List<Integer> numbers) {
		return this.equals(LottoNumbers.of(numbers));
	}

	public int compare(LottoNumbers lottoNumbers) {
		return (int) this.lottoNumbers.stream()
			.filter(lottoNumbers.lottoNumbers::contains)
			.count();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		LottoNumbers that = (LottoNumbers)obj;
		return lottoNumbers.equals(that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
