package sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class PositiveValues {

	List<PositiveValue> values;

	PositiveValues(String... values) {
		this.values = parseToPositiveList(values);
	}

	private List<PositiveValue> parseToPositiveList(String[] values) {
		if (values == null) {
			return Collections.emptyList();
		}

		return Arrays.stream(values)
				.map(this::getPositiveValue)
				.collect(Collectors.toList());
	}

	private PositiveValue getPositiveValue(String valueString) {
		if (valueString == null ||
				valueString.isEmpty()) {
			return new PositiveValue(0);
		}
		return new PositiveValue(Integer.parseInt(valueString));
	}

	int sum() {
		return values.stream()
				.mapToInt(PositiveValue::getValue)
				.sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PositiveValues positiveValues = (PositiveValues) o;
		return values.equals(positiveValues.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
