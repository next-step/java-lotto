package lottery;

import static lottery.Ticket.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lottery.exceptions.InvalidTicketSizeException;

public class LottoNumbers {

	private static final String NOT_FOUND_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 번호에 대한 정보가 없습니다";

	private Set<LottoNo> numbers;

	public static LottoNumbers from(Set<LottoNo> numbers) {
		if (numbers.size() != SIZE_OF_TICKET) {
			throw new InvalidTicketSizeException();
		}
		return new LottoNumbers(numbers);
	}

	public static LottoNumbers from(String[] split) {
		return new LottoNumbers(Arrays.stream(split).map(LottoNo::of)
			.sorted()
			.collect(Collectors.toCollection(LinkedHashSet::new)));
	}

	private LottoNumbers(Set<LottoNo> numbers) {
		setNumbers(numbers);
	}

	private void setNumbers(Set<LottoNo> numbers) {
		if (Objects.isNull(numbers) || numbers.isEmpty()) {
			throw new IllegalArgumentException(NOT_FOUND_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
		}
		this.numbers = numbers;
	}

	public Set<LottoNo> values() {
		return Collections.unmodifiableSet(numbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoNumbers))
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(numbers, that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
