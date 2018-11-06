package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Prize;

public class Lotto {

	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public Prize match(Lotto winningNumber) {
		int match = 0;
		for(Integer number : numbers) {
			if(winningNumber.hasNumber(number)) {
				++match;
			}
		}
		return Prize.get(match);
	}

	public boolean hasNumber(Integer number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}
}
