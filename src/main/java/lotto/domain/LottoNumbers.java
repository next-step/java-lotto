package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoNumbers {
	protected static final int LOTTO_NUMBER_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		validateDuplicate(lottoNumbers);
		validateSize(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	private void validateSize(List<LottoNumber> lottoNumbers) {
		if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException("로또 숫자가 없습니다.");
		}
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 숫자는 6개입니다.");
		}
	}

	private void validateDuplicate(List<LottoNumber> lottoNumbers) {
		if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public static LottoNumbers of(List<Integer> numbers) {
		return Optional.ofNullable(numbers)
			.orElseGet(Collections::emptyList).stream()
			.map(LottoNumber::of)
			.collect(collectingAndThen(toList(), LottoNumbers::new));
	}

	public static LottoNumbers createRandom() {
		return new LottoNumbers(createRandomNumbers());
	}

	private static List<LottoNumber> createRandomNumbers() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		while (lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
			lottoNumbers.add(LottoNumber.createRandom());
		}
		return new ArrayList<>(lottoNumbers);
	}

	public boolean isSameNumbers(List<Integer> numbers) {
		return this.equals(LottoNumbers.of(numbers));
	}

	public int compare(LottoNumbers lottoNumbers) {
		return (int) this.lottoNumbers.stream()
			.filter(lottoNumbers.lottoNumbers::contains)
			.count();
	}

	public int get(int index) {
		List<LottoNumber> sortedLottoNumbers = new ArrayList<>(this.lottoNumbers);
		LottoNumber lottoNumber = sortedLottoNumbers.get(index);
		return lottoNumber.getNumber();
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
