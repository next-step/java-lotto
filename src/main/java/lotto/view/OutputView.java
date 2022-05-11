package lotto.view;

import lotto.domain.PurchaseLottoGroup;

public class OutputView {

	private OutputView() {}

	public static void printPurchaseLottoGroup(PurchaseLottoGroup purchaseLottoGroup) {
		System.out.println(purchaseLottoGroup);
	}

	public static void printPurchaseQuantity(long quantity) {
		System.out.println(quantity + "개를 구매했습니다.");
	}
}
