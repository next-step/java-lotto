package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
	private final static int LOTTO_SIZE = 6;
	public static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 숫자는 %d개여야 합니다.";
	public static final String SEPARATOR = ",";
	private final Set<LottoNumber> lotto;

	private Lotto(List<LottoNumber> lotto) {
		this.lotto = new HashSet<>(lotto);
		validateLotto();
	}

	private void validateLotto() {
		if (this.lotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(String.format(LOTTO_LENGTH_ERROR_MESSAGE, LOTTO_SIZE));
		}
	}

	public static Lotto createFromNumbers(List<Integer> numbers) {
		return of(numbers.toArray(new Integer[0]));
	}

	public static Lotto createFromString(String value) {
		String[] numbers = value.split(SEPARATOR);
		Integer[] lottoNumbers = Arrays.stream(numbers)
			.map(String::trim)
			.map(Integer::parseInt)
			.toArray(Integer[]::new);
		return of(lottoNumbers);
	}

	public static Lotto of(Integer... numbers) {
		List<LottoNumber> lotto = new ArrayList<>();
		for (Integer number : numbers) {
			lotto.add(LottoNumber.of(number));

		}
		return new Lotto(lotto);
	}

	public int matchCount(Lotto winningLotto) {
		return (int)lotto.stream()
			.filter(winningLotto::isContains)
			.count();
	}

	public boolean isContains(LottoNumber number) {
		return this.lotto.contains(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}

	@Override
	public String toString() {
		return String.valueOf(lotto);
	}
}
