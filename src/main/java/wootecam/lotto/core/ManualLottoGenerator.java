package wootecam.lotto.core;

import wootecam.lotto.model.Lotto;

public class ManualLottoGenerator implements LottoGenerator {

	private final AddLottoFunction addLottoFunction;

	public ManualLottoGenerator(AddLottoFunction addLottoFunction) {
		this.addLottoFunction = addLottoFunction;
	}

	@Override
	public Lotto getLotto() {
		String manualLottoInput = addLottoFunction.apply();
		return new Lotto(manualLottoInput);
	}
}
