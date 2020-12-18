package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_NUMBER_RANGE_MIN = 1;
	private static final int LOTTO_NUMBER_RANGE_MAX = 45;

	private static final String VALIDATE_MSG_RANGE_WRONG = String.format("each lottoNumber range must in %s~%s",
			LOTTO_NUMBER_RANGE_MAX, LOTTO_NUMBER_RANGE_MAX);

	public static final List<Integer> LOTTO_NUMBER_LIST = IntStream
			.rangeClosed(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX)
			.boxed()
			.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

	private final int number;

	public LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private static void validate(int number) {
		if (!LOTTO_NUMBER_LIST.contains(number)) {
			throw new IllegalArgumentException(VALIDATE_MSG_RANGE_WRONG);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LottoNumber) {
			return ((LottoNumber) obj).number == this.number;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return String.format("%d", number);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}
}
