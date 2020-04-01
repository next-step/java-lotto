package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {

	private final List<Integer> candidateNumbers = IntStream.rangeClosed(LottoNo.LOWEST_NUMBER, LottoNo.HIGHEST_NUMBER)
			.boxed()
			.collect(Collectors.toList());

	public List<LottoNumber> autoTicketingLottoNumber(int count) {
		List<LottoNumber> printedNumbers = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			Collections.shuffle(candidateNumbers);
			printedNumbers.add(new LottoNumber(new ArrayList<>(candidateNumbers.subList(0, LottoNumber.NUMBER_SIZE))));
		}
		return printedNumbers;
	}

}
