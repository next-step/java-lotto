package camp.nextcamp.edu.lotto.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lotto {
	private static final int SIZE = 6;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		if (!checkSize(numbers)) {
			throw new RuntimeException("Lotto 갯수는 6개 여야됩니다.");
		}
		this.numbers = numbers;
	}

	private boolean checkSize(List<Integer> numbers) {
		return Optional.ofNullable(numbers)
			.orElse(new ArrayList<>())
			.size() == SIZE;
	}
}
