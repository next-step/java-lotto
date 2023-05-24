package step2.lotto.domain;

import java.util.List;

import step2.lotto.LottoNumberGenerator;

public class LottoTicket {
	private final List<Integer> numbers;

	public static final int PRICE = 1000;

	private LottoTicket(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public static LottoTicket from(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}

		return new LottoTicket(numbers);
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
