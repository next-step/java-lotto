package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum CalculateWinnings {
	FIRST_PLACE(1, (number) -> 2000000000 * number),
	//SECOND_PLACE(2, (number) -> 1500000 * number),
	THIRD_PLACE(3, (number) -> 1500000 * number),
	FOURTH_PLACE(4, (number) -> 500000 * number),
	FIFTH_PLACE(5, (number) -> 5000 * number);

	private final int place;
	private final Function<Integer, Integer> expression;

	CalculateWinnings(int place, Function<Integer, Integer> expression) {
		this.place = place;
		this.expression = expression;
	}

	public int calculate(int numbers){
		return expression.apply(numbers);
	}

	public static CalculateWinnings of(int place) {
		return Arrays.stream(values())
			.filter(c -> c.place == place)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
