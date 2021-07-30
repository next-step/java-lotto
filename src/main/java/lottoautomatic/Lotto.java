package lottoautomatic;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private static final List<Integer> NUMBERS = new ArrayList<>();

	public Lotto() {
		generateNumbers();
	}

	private void generateNumbers() {
		for (int i = 0; i < 6; i++) {
			NUMBERS.add(i+1);
		}
	}

	public List<Integer> numbers() {
		return NUMBERS;
	}



}
