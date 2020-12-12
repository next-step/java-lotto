package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos(PurchaseInput inputResult) {
		this.lottos = new ArrayList<>();
		purchaseManualLottos(inputResult);
		purchaseAutoLottos(inputResult);
	}

	public static Lottos purchase(PurchaseInput inputResult) {
		return new Lottos(inputResult);
	}

	private int getAutoPurchaseCount(PurchaseInput input) {
		return input.getAutoPurchaseAmount() / Lotto.LOTTO_PRICE;
	}

	private void purchaseManualLottos(PurchaseInput input) {
		List<List<LottoNo>> manualNumbers = input.getManualNumbers();
		for (List<LottoNo> lottoNumber : manualNumbers) {
			this.lottos.add(Lotto.of(lottoNumber));
		}
	}

	private void purchaseAutoLottos(PurchaseInput input) {
		int lottoCount = getAutoPurchaseCount(input);
		for (int i = 0; i < lottoCount; i++) {
			this.lottos.add(Lotto.of(new LottoAutoGenerator()));
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
