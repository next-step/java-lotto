package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;
	private final int lottoNumber;

	static {
		LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
			.boxed()
			.collect(Collectors.toMap(Function.identity(), LottoNumber::new));
	}

	private LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber of(int number) {
		return Optional.ofNullable(LOTTO_NUMBERS.get(number))
			.orElseThrow(() -> new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_RANGE));
	}

	public int compare(LottoNumber lottoNumber) {
		return Integer.compare(this.lottoNumber, lottoNumber.lottoNumber);
	}

	@Override
	public String toString() {
		return Integer.toString(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber lottoNumber1 = (LottoNumber)o;
		return lottoNumber == lottoNumber1.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}
