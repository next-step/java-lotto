package lottoautomatic;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	public List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			numbers.add(i+1);
		}
		return numbers;
	}

}
