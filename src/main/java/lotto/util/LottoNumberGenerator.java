package lotto.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

abstract class LottoNumberGenerator {

	static int MINIMUM_NUMBER_BOUND = 1;
	static int MAXIMUM_NUMBER_BOUND = 45;

	public static List<LottoNumber> getLottoNumbers() {
		List<LottoNumber> lottoNumbers;
		lottoNumbers = generateLottoNumbers();
		sortDescLottoNumbers(generateLottoNumbers());
		return lottoNumbers;
	}

	static List<LottoNumber> generateLottoNumbers() {
		return IntStream.rangeClosed(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	static void sortDescLottoNumbers(List<LottoNumber> lottoNumberList) {
		lottoNumberList.sort(Comparator.comparing(LottoNumber::getNumber));
	}
}
