package lotto.domain;

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

	public int compare(Lotto lotto) {
		return this.lottoNumbers.compare(lotto.lottoNumbers);
	}

	public LottoResult compareResult(Lotto lotto) {
		return LottoResult.of(compare(lotto));
	}

	public boolean isSameLottoNumbers(List<Integer> numbers) {
		return lottoNumbers.isSameNumbers(numbers);
	}

	public int getNumber(int index) {
		return lottoNumbers.get(index);
	}

	public int size() {
		return LottoNumbers.LOTTO_NUMBER_SIZE;
	}
}
