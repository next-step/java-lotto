import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ParsedNumbers {

	private final List<ParsedNumber> numbers;

	public ParsedNumbers(ParsedNumber number) {
		this.numbers = Collections.singletonList(number);
	}

	public ParsedNumbers(List<ParsedNumber> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public int sum() {
		return this.numbers.stream()
			.mapToInt(ParsedNumber::getNumber)
			.sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ParsedNumbers))
			return false;
		ParsedNumbers numbers1 = (ParsedNumbers)o;
		return Objects.equals(numbers, numbers1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
