package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ListOfLottoNumbers {

	private final List<LottoNumbers> listOfNumbers;

	private ListOfLottoNumbers(List<LottoNumbers> listOfNumbers) {
		this.listOfNumbers = listOfNumbers;
	}

	public static ListOfLottoNumbers of(List<List<LottoNum>> listOfNumbers) {
		return new ListOfLottoNumbers(
			listOfNumbers.stream()
				.map(LottoNumbers::of)
				.collect(Collectors.toList())
		);
	}

	public List<LottoNumbers> getListOfNumbers() {
		return listOfNumbers;
	}
}
