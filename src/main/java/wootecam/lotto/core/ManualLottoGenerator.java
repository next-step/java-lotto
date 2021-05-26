package wootecam.lotto.core;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.ui.InputView;

public class ManualLottoGenerator implements LottoGenerator {

	private InputView inputView;

	public ManualLottoGenerator(InputView inputView) {
		this.inputView = inputView;
	}

	@Override
	public Lotto getLotto() {
		String lottoNumbers = this.inputView.makeManualLottoNumbersInput();
		return new Lotto(lottoNumbers);
	}
}
