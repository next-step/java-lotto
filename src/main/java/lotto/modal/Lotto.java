package lotto.modal;

import java.util.List;

public class Lotto {

	private final List<LottoNumber> lotto;

	public Lotto() {

		this(generateRandomLotto());
	}

	public Lotto(List<LottoNumber> manualLotto) {

		this.lotto = manualLotto;
	}

	private static List<LottoNumber> generateRandomLotto() {

		return null;
	}
}
