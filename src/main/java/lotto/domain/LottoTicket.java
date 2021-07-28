package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

	private final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> numbers) {
		this.lottoNumbers = numbers;
	}

	public List<Integer> getNumbers() {
		return lottoNumbers.stream()
				.map(LottoNumber::getNumber)
				.sorted()
				.collect(Collectors.toList());
	}
}
