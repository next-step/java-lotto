package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos(PurchaseInput inputResult) {
		this.lottos = new ArrayList<>();
		purchaseLottos(inputResult);
	}

	public static Lottos purchase(PurchaseInput inputResult) {
		return new Lottos(inputResult);
	}

	private int getPurchaseCnt(PurchaseInput input) {
		return input.getPurchaseAmount() / Lotto.LOTTO_PRICE;
	}

	private void purchaseLottos(PurchaseInput input) {
		int lottoCnt = getPurchaseCnt(input);
		for (int i = 0; i < lottoCnt; i++) {
			this.lottos.add(Lotto.of(new LottoAutoGenerator()));
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
