package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.utils.LottoCountCalculator;
import lotto.utils.PrizeRate;

public class LottoOutputView {

	private static final String BUY_RESULT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	private static final String RESULT_START_MESSAGE = "당첨 통계";
	private static final String DASH_LINE = "---------";
	private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
	private static final String EMPTY_MESSAGE = " ";

	public static void printLottoCount(LottoCount lottoCount) {
		System.out.printf(BUY_RESULT_MESSAGE, lottoCount.getManualLottoCount(), lottoCount.getAutoLottoCount());
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
		winPrizes.winLottos()
			.stream()
			.filter(prize -> prize != Prize.MISS)
			.forEach(prize -> {
				String message = BONUS_MATCH_MESSAGE;
				if (prize != Prize.SECOND) {
					message = EMPTY_MESSAGE;
				}
				prizePrizeStats(winPrizes, prize, message);
			});
		System.out.println("총 수익률은 " + PrizeRate.calculatePrizeEarningRate(totalWinningMoney, purchaseMoney) + "입니다.");
	}

	private static void prizePrizeStats(WinPrizes winPrizes, Prize prize, String message) {
		System.out.println(prize.getCountOfMatch() +
			"개 일치" +
			message +
			"(" + prize.getWinningMoney() + ")" +
			"-" + winPrizes.findWinPrizeGrade(prize) + "개");
	}

}
