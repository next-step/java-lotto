package lotto;

import lotto.controller.LottoController;
import lotto.domain.PurchaseLottoGroup;

public class LottoApplication {
	public static void main(String[] args) {
		LottoController lottoController = new LottoController();

		PurchaseLottoGroup purchaseLottoGroup = lottoController.purchaseLotto();
		lottoController.ranking(purchaseLottoGroup);
	}
}
