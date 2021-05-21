package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class InputView {

	public static void printPurchaseLottos(List<LottoNumbers> purchaseLottos) {
		System.out.printf("%d개를 구매했습니다.\n", purchaseLottos.size());

		for (LottoNumbers lotto : purchaseLottos) {
			System.out.println(lotto);
		}
		System.out.println();
	}

}
