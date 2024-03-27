package lotto.view;

import lotto.domain.*;

public class OutputView {
	public MyLottos printBuyLottos(Integer pay, MyLottos manuallyLottos) {
		pay -= manuallyLottos.getLottoCount() * 1000;
		MyLottos myLottos = MyLottos.rollLottos(pay);
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
				manuallyLottos.getLottoCount(),
				myLottos.getLottoCount());

		for (int i = 0; i < manuallyLottos.getLottoCount(); i++) {
			System.out.println(manuallyLottos.getLottos().get(i).getNumbersToString());
		}

		for (int i = 0; i < myLottos.getLottoCount(); i++) {
			System.out.println(myLottos.getLottos().get(i).getNumbersToString());
		}

		return MyLottos.makeLottos(myLottos,manuallyLottos);
	}

	public void printWinnersStatistics(final String winNumber, final MyLottos myLottos, final String bonusNumber) {
		Winners winners = myLottos.findWinner(new Lotto(winNumber), new LottoNumber(Integer.parseInt(bonusNumber)));
		System.out.println("당첨 통계");
		System.out.println("---------");
		printWinners(winners);
		printTotalReturn(winners, myLottos.getLottoCount() * 1000);
	}

	public void printTotalReturn(final Winners winners, final Integer pay) {
		System.out.println("총 수익률은 " + (double) winners.getTotalAmount() / pay + "입니다.");
	}

	private void printWinners(final Winners winners) {
		winners.getWinners()
				.stream().filter(winner -> winner.getAmount() != 0)
				.forEach(winner -> {
					if (winner.isSecond()) {
						System.out.println(winner.getCollectedCount() + "개 일치, 보너스 볼 일치 (" + winner.getAmount() + "원) - " + winner.getCount() + "개");
						return;
					}
					System.out.println(winner.getCollectedCount() + "개 일치 (" + winner.getAmount() + "원) - " + winner.getCount() + "개");
				});
	}
}
