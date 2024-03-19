package lotto.view;

import lotto.domain.AmountEnum;
import lotto.domain.Lotto;
import lotto.domain.MyLottos;

import java.util.Map;

public class OutputView {
	public MyLottos printBuyLottos(Integer pay) {
		MyLottos myLottos = MyLottos.rollLottos(pay);

		System.out.println(myLottos.getLottoCount() + "개를 구매했습니다.");

		for (int i = 0; i < myLottos.getLottoCount(); i++) {
			System.out.println(myLottos.getLottos().get(i).getNumbersToString());
		}
		return myLottos;
	}

	public void printWinnersStatistics(final String winNumber, final MyLottos myLottos) {
		Map winner = myLottos.findWinner(new Lotto(winNumber));
		System.out.println("당첨 통계");
		System.out.println("---------");
		printWinners(winner);
		printTotalReturn(winner, myLottos.getLottoCount() * 1000);
	}

	public void printTotalReturn(final Map<AmountEnum, Long> hashMap, final Integer pay) {
		int totalAmount = 0;
		for (int i = 3; i <= 6; i++) {
			totalAmount += AmountEnum.from(i).getAmount() * hashMap.getOrDefault(AmountEnum.from(i), 0L);
		}
		System.out.println("총 수익률은 " + (double) totalAmount / pay + "입니다.");
	}

	private void printWinners(final Map<AmountEnum, Long> hashMap) {
		for (int i = 3; i <= 6; i++) {
			System.out.println(i + "개 일치 (" + AmountEnum.from(i).getAmount() + "원)- " + hashMap.getOrDefault(AmountEnum.from(i), 0L) + "개");
		}
	}
}
