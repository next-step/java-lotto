package lottoautomatic;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private static final List<Integer> NUMBERS = new ArrayList<>();

	public Lotto() {
		generateNumbers();
	}

	private void generateNumbers() {
		LottoNumberGenerator generator = new LottoNumberGenerator();
		NUMBERS.addAll(generator.generate());
	}

	public List<Integer> numbers() {
		return NUMBERS;
	}



}
