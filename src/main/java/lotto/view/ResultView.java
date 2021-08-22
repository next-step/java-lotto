package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {
	private static final String NUMBER_OF_PURCHASE_LOTTO = "개를 구매했습니다.";

	public static void outputPurchaseLotto(Lottos lottos) {
		List<Lotto> lottoList = lottos.getLottos();

		int numberOfLottos = lottoList.size();
		System.out.println(numberOfLottos + NUMBER_OF_PURCHASE_LOTTO);

		lottoList.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}
}
