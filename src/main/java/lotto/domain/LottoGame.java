package lotto.domain;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;

	private int lottoGameCount;

	private LottoNumbers lottoNumbers;

	public int calculateLottoCount(int input) {
		this.lottoGameCount = input/LOTTO_PRICE;
		return this.lottoGameCount;
	}

	public LottoNumbers generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		lottoNumbers = new LottoNumbers();
		return lottoNumbers.generateLottoNumbers(lottoGameCount, numberGenerator);
	}
}
