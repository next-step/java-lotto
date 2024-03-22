package lotto.view;

import lotto.domain.AmountEnum;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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

	public void printWinnersStatistics(final String winNumber, final MyLottos myLottos, final String bonusNumber) {
		Map winner = myLottos.findWinner(new Lotto(winNumber), new LottoNumber(Integer.parseInt(bonusNumber)));
		System.out.println("당첨 통계");
		System.out.println("---------");
		printWinners(winner);
		printTotalReturn(winner, myLottos.getLottoCount() * 1000);
	}

	public void printTotalReturn(final Map<AmountEnum, Long> hashMap, final Integer pay) {
		int totalAmount = 0;
		for (int i = 3; i <= 6; i++) {
			totalAmount += AmountEnum.from(i,false).getAmount() * hashMap.getOrDefault(AmountEnum.from(i,false), 0L);
		}
		totalAmount += AmountEnum.from(5,true).getAmount() * hashMap.getOrDefault(AmountEnum.from(5,true), 0L);
		System.out.println("총 수익률은 " + (double) totalAmount / pay + "입니다.");
	}

	private void printWinners(final Map<AmountEnum, Long> hashMap) {
		for (int i = 3; i <= 6; i++) {
			System.out.println(i + "개 일치 (" + AmountEnum.from(i,false).getAmount() + "원)- " + hashMap.getOrDefault(AmountEnum.from(i,false), 0L) + "개");
		}
		System.out.println(5 + "개 일치 보너스 볼 일치(" + AmountEnum.from(5,true).getAmount() + "원)- " + hashMap.getOrDefault(AmountEnum.from(5,true), 0L) + "개");
	}
}
