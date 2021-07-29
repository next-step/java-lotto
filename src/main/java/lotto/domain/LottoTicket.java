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

	public static LottoTicket from(List<Integer> numbers) {
		return new LottoTicket(numbers.stream()
								.map(LottoNumber::new)
								.collect(Collectors.toList()));
	}

	public static LottoTicket from(String winningNumbers) {
		String[] numbers = winningNumbers.trim().split(DELIMITER);
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

	public LottoPrize compareTo(LottoTicket lottoTicket) {
		long count = lottoNumbers.stream()
			.filter(lottoTicket.lottoNumbers::contains)
			.count();

		return LottoPrize.fromMatchCount(count);
	}
}
