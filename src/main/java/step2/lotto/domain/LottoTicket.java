package step2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step2.lotto.LottoNumberGenerator;

public class LottoTicket {
	private final List<LottoNumber> numbers;

	public static final int PRICE = 1000;

	private LottoTicket(List<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers
			.stream()
			.map(LottoNumber::getNumber)
			.collect(Collectors.toList());
	}

	public static LottoTicket fromNumbers(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}

		return new LottoTicket(
			numbers.stream()
				.map(LottoNumber::from)
				.collect(Collectors.toList())
		);
	}

	public static LottoTicket from(LottoNumberGenerator lottoNumberGenerator) {
		return new LottoTicket(lottoNumberGenerator.generate());
	}

	public long countMatch(LottoTicket lottoTicket) {
		return numbers.stream()
			.filter(number -> lottoTicket.numbers.contains(number))
			.count();
	}
}
