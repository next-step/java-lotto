package step2.model;

import static step2.model.LottoNumbers.randomNumbers;

public class Lotto {

	private LottoNumbers lottoNumbers;


	private Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public LottoNumbers getLotto() {
		return lottoNumbers;
	}

	public static Lotto randomLotto() {
		return new Lotto(randomNumbers());
	}

	public static Lotto handLotto(LottoNumbers lottoNumbers){
		return new Lotto(lottoNumbers);
	}

}