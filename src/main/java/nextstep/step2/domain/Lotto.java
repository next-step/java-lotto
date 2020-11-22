package nextstep.step2.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
	private static final String WRONG_LOTTO_NUMBERS = "로또 번호는 6개여야 합니다.";
	private static final String WRONG_WINNER_NUMBERS = "지난주 로또 당첨번호는 모두 숫자여야 합니다.";
	protected static final int LOTTO_SIZE = 6;
	private Set<LottoNumber> numbers;

	public Lotto() {
	}
	public Lotto(Set<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public void validate() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(WRONG_LOTTO_NUMBERS);
		}
	}

	public Lotto getLastWeekLotto(String winnerNumbers) {
		String[] winningNumberSplit = winnerNumbers.replaceAll(" ", "").split(",");
		Set<LottoNumber> winningNumbers =  Stream.of(winningNumberSplit)
				.map(number -> new LottoNumber(LottoNumber.getValidateNumber(number)))
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		return new Lotto(winningNumbers);
	}
}
