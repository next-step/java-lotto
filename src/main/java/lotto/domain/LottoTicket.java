package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

	private static final String DELIMITER = ",";

	private final List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> numbers) {
		this.lottoNumbers = numbers;
	}

	public static LottoTicket from(List<LottoNumber> numbers) {
		return new LottoTicket(numbers);
	}

	public static LottoTicket from(String winningNumbers) {
		String[] numbers = winningNumbers.split(DELIMITER);
		List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
											.map(number -> new LottoNumber(Integer.parseInt(number)))
											.collect(Collectors.toList());
		return new LottoTicket(lottoNumbers);
	}

	public List<Integer> getNumbers() {
		return lottoNumbers.stream()
				.map(LottoNumber::getNumber)
				.sorted()
				.collect(Collectors.toList());
	}
}
