package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoReward;
import lotto.domain.LottoRewards;
import lotto.domain.RewardType;

import java.util.List;

public class ResultView {

    private static final int BRAKE_EVEN_POINT = 1;

    public static void printPurchasePriceInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printAllLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        printNewLine();
    }

    public static void printWinningLottoNumberInputCommand() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printWinningStatics(LottoRewards lottoRewards, long purchasePrice) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (RewardType mc : RewardType.values()) {
            String phrase = mc.phrase();
            LottoReward lottoReward = lottoRewards.get(mc);

            if (lottoReward == null) {
                System.out.println(phrase + "- 0개");
                continue;
            }
            System.out.println(phrase + "- " + lottoReward.count() + "개");
        }

        double totalProfitRate = (double) lottoRewards.totalProfit() / purchasePrice;
        System.out.print("총 수익률은 " + String.format("%.2f", totalProfitRate) + "입니다.");

        if (totalProfitRate < BRAKE_EVEN_POINT) {
            printBrakeEvenPointMessage(totalProfitRate);
        }
    }

    private static void printBrakeEvenPointMessage(double totalProfitRate) {
        System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static void printNewLine() {
        System.out.println();
    }
}
