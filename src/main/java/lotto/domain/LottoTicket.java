package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

	private final List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> numbers) {
		this.lottoNumbers = numbers;
	}

	public static LottoTicket from(List<Integer> numbers) {
		return new LottoTicket(numbers.stream()
								.map(LottoNumber::new)
								.collect(Collectors.toList()));
	}

	public static LottoTicket from(WinningLottoNumbers winningNumbers) {
		return from(winningNumbers.getWinningNumbers());
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
