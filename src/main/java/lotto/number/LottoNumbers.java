package lotto.number;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

	public static final int LOTTO_NUMBER_SIZE = 6;
	private static final String LOTTO_VALIDATE_SIZE_WRONG =
			String.format("lottoNumbers size must be %s", LOTTO_NUMBER_SIZE);
	private static final String LOTTO_VALIDATE_DUPLICATED = "lottoNumber is duplicated";

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumberList) {
		validateSize(lottoNumberList);
		validateUnique(lottoNumberList);
		this.lottoNumbers = toSortedUnmodifiableList(lottoNumberList);
	}

	private static List<LottoNumber> toSortedUnmodifiableList(List<LottoNumber> lottoNumberList) {
		List<LottoNumber> sortList = new ArrayList<>(lottoNumberList);
		Collections.sort(sortList);
		return Collections.unmodifiableList(sortList);
	}

	private static void validateSize(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_SIZE_WRONG);
		}
	}

	private static void validateUnique(List<LottoNumber> lottoNumbers) {
		Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
		if (uniqueNumbers.size() != lottoNumbers.size()) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_DUPLICATED);
		}
	}

	List<LottoNumber> getMatchedLottoNumbers(LottoNumbers otherLottoNumbers) {
		return this.lottoNumbers.stream()
				.filter(otherLottoNumbers::contains)
				.collect(Collectors.toList());
	}

	boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		List<String> numbers = lottoNumbers.stream()
				.map(LottoNumber::toString)
				.collect(Collectors.toList());
		return String.join(", ", numbers);
	}
}
