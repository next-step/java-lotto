package lotto;

import lombok.Getter;

@Getter
public class Lotto {

	private final LottoNumbers lottoNumbersOfUser;

	public Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbersOfUser = lottoNumbers;
	}

	public int getSameCountWith(LottoNumbers winningNumbers) {
		return lottoNumbersOfUser.getSameCountWith(winningNumbers);
	}
}
