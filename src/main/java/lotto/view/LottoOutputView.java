package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.utils.LottoCountCalculator;
import lotto.utils.PrizeRate;

public class LottoOutputView {

	private static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
	private static final String RESULT_START_MESSAGE = "당첨 통계";
	private static final String DASH_LINE = "---------";
	public static final int ZERO_POINT = 0;

	public static void printLottoCount(Money money) {
		System.out.println(money.getLottoCount() + BUY_RESULT_MESSAGE);
	}

	public static void printLottoList(Lottos lottos) {
		lottos.getLottos().stream().map(LottoOutputView::getLottoNumbers).forEach(System.out::println);
		System.out.print("\n");
	}

	private static List<Integer> getLottoNumbers(Lotto lotto) {
		return lotto.getLottoNumbers()
			.stream()
			.map(LottoNumber::getLottoNumber)
			.sorted()
			.collect(Collectors.toList());
	}

	public static void displayLottoPrize(WinPrizes winPrizes) {
		int purchaseMoney = LottoCountCalculator.calculateLottoMoney(winPrizes.getLottoCount());
		System.out.println(RESULT_START_MESSAGE);
		System.out.println(DASH_LINE);
		int totalWinningMoney = winPrizes.getTotalWinningMoney();
		winPrizes.winLottos().forEach(prize -> printResultStatus(winPrizes, prize));
		System.out.println("총 수익률은 " + PrizeRate.calculatePrizeEarningRate(totalWinningMoney, purchaseMoney) + "입니다.");
	}

	private static void printResultStatus(WinPrizes winPrizes, Prize prize) {
		if (prize.getWinningMoney() > ZERO_POINT) {
			System.out.println(prize.getCountOfMatch() +
				"개 일치" +
				"(" + prize.getWinningMoney() + ")" +
				"-" + winPrizes.findWinPrizeGrade(prize) + "개");
		}
	}

}
