package lotto;

import java.util.List;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	private Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto of(List<Integer> numbers) {
		return new Lotto(LottoNumbers.of(numbers));
	}

	public static Lotto createRandom() {
		return new Lotto(LottoNumbers.createRandom());
	}
}
