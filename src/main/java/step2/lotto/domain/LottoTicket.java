package step2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import step2.lotto.LottoNumberGenerator;

public class LottoTicket {
	private final List<LottoNumber> numbers;

	public static final int LOTTO_NUMBER_LENGTH = 6;

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

	public static LottoTicket from(List<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}

		if (numbers.stream().distinct().count() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
		}

		return new LottoTicket(numbers);
	}

	public static LottoTicket fromLottoNumberGenerator(LottoNumberGenerator lottoNumberGenerator) {
		return LottoTicket.from(lottoNumberGenerator.generate());
	}


	public static LottoTicket fromNumbers(List<Integer> numbers) {
		return LottoTicket.from(
			numbers.stream()
				.map(LottoNumber::from)
				.collect(Collectors.toList())
		);
	}

	public int countMatch(LottoTicket lottoTicket) {
		return (int)numbers.stream()
			.filter(number -> lottoTicket.numbers.contains(number))
			.count();
	}

	public WinningCondition match(LottoTicket winningLottoTicket) {
		int count = countMatch(winningLottoTicket);

		return WinningCondition.from(count);
	}
}
