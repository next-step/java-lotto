package lottery;

import static lottery.Ticket.*;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import lottery.exceptions.InvalidTicketSizeException;

public class LottoNumbers {

	private final Set<Integer> numbers;

	public static LottoNumbers from(Set<Integer> numbers) {
		if (numbers.size() != SIZE_OF_TICKET) {
			throw new InvalidTicketSizeException();
		}
		return new LottoNumbers(numbers);
	}

	private LottoNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getValues() {
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
