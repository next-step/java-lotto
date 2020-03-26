package sum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ValueList {

	List<PositiveValue> values;

	ValueList(String[] values) {
		this.values = parseToPositiveList(values);
	}

	private List<PositiveValue> parseToPositiveList(String[] values) {
		return Arrays.stream(values)
				.map(this::getPositiveValue)
				.collect(Collectors.toList());
	}

	private PositiveValue getPositiveValue(String valueString) {
		if (valueString == null ||
				valueString.isEmpty()) {
			throw new IllegalArgumentException(
					String.format("Parse valueString to PositiveValue failed. " +
							"Each Number valueString must not be Null or Empty : valueString=%s", valueString));
		}

		return new PositiveValue(Integer.parseInt(valueString));
	}

	int sum() {
		return values.stream()
				.mapToInt(PositiveValue::getValue)
				.sum();
	}
}
