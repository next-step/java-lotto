package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningLotto {

	private final Lotto winningLotto;

	public WinningLotto(String input) {
		this.winningLotto = new Lotto(this.createLottoNumbers(input));
	}

	public Set<LottoNumber> createLottoNumbers(String input) {
		Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
		for (String numberString : input.split(", ")) {
			lottoNumbers.add(LottoNumber.of(numberString));
		}
		return lottoNumbers;
	}

	public void calculateScore(PurchasedLottos purchasedLottos, LottoNumber bonusNumber) {
		if (this.winningLotto.getLottoNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
		}
		purchasedLottos.calculateScore(this.winningLotto, bonusNumber);
	}
}
