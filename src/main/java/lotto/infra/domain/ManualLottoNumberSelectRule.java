package lotto.infra.domain;

import lotto.domain.LottoNumberSelectRule;
import lotto.domain.LottoNumbers;

public class ManualLottoNumberSelectRule implements LottoNumberSelectRule {

	private final LottoNumbers numbers;

	public ManualLottoNumberSelectRule(LottoNumbers numbers) {
		this.numbers = numbers;
	}

	@Override
	public LottoNumbers select() {
		return numbers;
	}
}
