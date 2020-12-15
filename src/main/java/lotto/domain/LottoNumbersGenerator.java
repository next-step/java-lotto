package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersGenerator {

	private LottoNumbersGenerator() {
		throw new AssertionError();
	}

	public static AutoLottoNumbers generate(long amount) {
		List<LottoNumber> numbers = new ArrayList<>();
		for(int i = 0; i < amount; i++) {
			numbers.add(LottoNumberAutoGenerator.generate());
		}
		return new AutoLottoNumbers(numbers);
	}
}
