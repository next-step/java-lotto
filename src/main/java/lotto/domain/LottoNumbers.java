package lotto.domain;

import java.util.*;

public class LottoNumbers {

	public static final int LENGTH = 6;
	public static final String MESSAGE_EXIST_DUPLICATE_NUMBER = "로또번호중에서 중복된 숫자가 포함되어 있습니다.";
	public static final String MESSAGE_LOTTO_NUMBER_MUST_BE_SIX_DIGIT = "로또는 숫자 %d개로 이루어져야 합니다.";

	private final Set<LottoNumber> lottoNumbers;

	public LottoNumbers(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public LottoNumbers(List<Integer> numbers) {
		lottoNumbers = new LinkedHashSet<>();
		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}
		validationNumbers(numbers);
	}

	public LottoNumbers(RandomNumbersGenerator randomNumbersGenerator) {
		this(randomNumbersGenerator.generateNumbers());
	}

	private void validationNumbers(List<Integer> numbers) {
		validationSize(numbers);
		validationDuplicate();
	}

	private void validationDuplicate() {
		if (this.lottoNumbers.size() != LENGTH) {
			throw new IllegalArgumentException(MESSAGE_EXIST_DUPLICATE_NUMBER);
		}
	}

	private void validationSize(List<Integer> numbers) {
		if (numbers == null || numbers.size() != LENGTH) {
			throw new IllegalArgumentException(String.format(MESSAGE_LOTTO_NUMBER_MUST_BE_SIX_DIGIT, LENGTH));
		}
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public Rank findRank(LottoNumbers winLottoNumbers) {
		int matchCount = 0;
		for (LottoNumber lottoNumber : lottoNumbers) {
			matchCount += containLottoNumber(lottoNumber, winLottoNumbers);
		}
		return Rank.findRankByMatchCount(matchCount);
	}

	private int containLottoNumber(LottoNumber lottoNumber, LottoNumbers winLottoNumbers) {
		if (winLottoNumbers.contains(lottoNumber)) {
			return 1;
		}
		return 0;
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
