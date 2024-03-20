package lotto.domain;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	private LottoNumbers lottoNumber;

	public Lotto(LottoNumbers lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public LottoNumbers getLottoNumber() {
		return lottoNumber;
	}
	
}
