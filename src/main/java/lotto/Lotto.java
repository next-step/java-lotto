package lotto;

public class Lotto {

	private final LottoNumbers lottoNumbersOfUser;

	private Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbersOfUser = lottoNumbers;
	}

	public static Lotto of(LottoNumbers lottoNumbers) {
		return new Lotto(lottoNumbers);
	}

	public LottoNumbersDto getLottoNumbersDto() {
		return lottoNumbersOfUser.toDto();
	}
}
