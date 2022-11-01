package step2.model;

import step2.util.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

	private final List<Integer> lottoNumbers;

	public Lotto(final LottoGenerator lottoGenerator) {
		lottoNumbers = lottoGenerator.generating();
	}

	public static Lotto generate(final LottoGenerator lottoGenerator) {
		return new Lotto(lottoGenerator);
	}

	public int checkHit(final List<Integer> hitNumbers){
		return (int) hitNumbers.stream()
				.mapToInt(num -> num)
				.filter(lottoNumbers::contains)
				.count();
	}

	public List<Integer> getLottoNumbers() {
		return List.copyOf(lottoNumbers);
	}
}
