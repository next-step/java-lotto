package lotto.domain;

import java.util.*;

public class Lotto {

	public static final int NUMBER_LENGTH = 6;
	public static final String MESSAGE_EXIST_DUPLICATE_NUMBER = "로또번호중에서 중복된 숫자가 포함되어 있습니다.";
	public static final String MESSAGE_RULE_LOTTO_NUMBER_COUNT = "로또는 숫자 %d개로 이루어져야 합니다.";

	private final Set<LottoNumber> lottoNumbers;

	public Lotto(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public Lotto(List<Integer> numbers) {
		validationSize(numbers);

		lottoNumbers = new LinkedHashSet<>();
		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}

		validationDuplicate();
	}

	public Lotto(RandomNumbersGenerator randomNumbersGenerator) {
		this(randomNumbersGenerator.generateNumbers());
	}

	private void validationDuplicate() {
		if (this.lottoNumbers.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_EXIST_DUPLICATE_NUMBER);
		}
	}

	private void validationSize(List<Integer> numbers) {
		if (numbers == null || numbers.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(String.format(MESSAGE_RULE_LOTTO_NUMBER_COUNT, NUMBER_LENGTH));
		}
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public int matchCount(Lotto winningLotto) {
		return lottoNumbers.stream()
				.filter(winningLotto::contains)
				.mapToInt(x -> 1)
				.sum();
	}

	public Rank findRank(Lotto winningLotto) {
		return Rank.findRankByMatchCount(matchCount(winningLotto));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto that = (Lotto) o;
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
