package lotto.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

interface LottoNumberGenerator {

	int MINIMUM_NUMBER_BOUND = 1;
	int MAXIMUM_NUMBER_BOUND = 45;
	int START_INDEX_OF_NUMBER_ELEMENTS = 0;
	int NUMBER_OF_NUMBER_ELEMENTS = 6;

	static List<LottoNumber> generateLottoNumbers() {
		return IntStream.rangeClosed(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	static void sortDescLottoNumbers(List<LottoNumber> lottoNumberList) {
		lottoNumberList.sort(Comparator.comparing(LottoNumber::getNumber));
	}
}
