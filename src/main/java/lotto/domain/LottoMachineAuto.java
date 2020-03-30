package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachineAuto {

	private final List<Integer> candidateNumbers = IntStream.rangeClosed(LottoNumber.LOWEST_NUMBER, LottoNumber.HIGHEST_NUMBER)
			.boxed()
			.collect(Collectors.toList());

	List<LottoNumber> ticketingLottoNumber(int count) {
		List<LottoNumber> printedNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Collections.shuffle(candidateNumbers);
			printedNumbers.add(new LottoNumber(new ArrayList<>(candidateNumbers.subList(0, LottoNumber.NUMBER_SIZE))));
		}
		return printedNumbers;
	}

}
