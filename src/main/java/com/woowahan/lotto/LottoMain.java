package com.woowahan.lotto;

import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;
import com.woowahan.lotto.view.PurchaseInputView;

public class LottoMain {

	public static void main(String[] args) {
		PurchaseInput purchaseInput = PurchaseInput.of(PurchaseInputView.getPurchaseAmount());
		Lottos lottos = Lottos.purchase(purchaseInput);
		System.out.println(lottos);

	}
}
