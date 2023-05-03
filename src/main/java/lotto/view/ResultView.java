package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.LottoRewards;
import lotto.domain.RewardType;

import java.util.List;

import static lotto.domain.RewardType.FIVE_AND_BONUS;

public class ResultView {

    private static final int BRAKE_EVEN_POINT = 1;

    public static void printPurchasePriceInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        printNewLine();
    }

    public static void printWinningLottoInputCommand() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printBonusLottoNumberInputCommand() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printWinningStatics(LottoRewards lottoRewards, double totalProfitRate) {
        printAllLottoRewardCount(lottoRewards);
        printTotalProfitRate(totalProfitRate);
    }

    private static void printAllLottoRewardCount(LottoRewards lottoRewards) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (RewardType mc : RewardType.values()) {
            printLottoRewardCount(lottoRewards, mc);
        }
    }

    private static void printLottoRewardCount(LottoRewards lottoRewards, RewardType rewardType) {
        LottoReward lottoReward = lottoRewards.get(rewardType);
        String phrase = phrase(rewardType);

        if (lottoReward == null) {
            System.out.println(phrase + "- 0개");
            return;
        }
        System.out.println(phrase + "- " + lottoReward.count() + "개");
    }

    private static String phrase(RewardType rewardType) {
        StringBuilder sb = new StringBuilder();

        sb.append(rewardType.matchCount()).append("개 일치");

        if (rewardType == FIVE_AND_BONUS) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(rewardType.reward()).append("원)");

        return sb.toString();
    }

    private static void printTotalProfitRate(double totalProfitRate) {
        System.out.print("총 수익률은 " + String.format("%.2f", totalProfitRate) + "입니다.");

        if (totalProfitRate < BRAKE_EVEN_POINT) {
            printBrakeEvenPointMessage();
        }
    }

    private static void printBrakeEvenPointMessage() {
        System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static void printNewLine() {
        System.out.println();
    }
}
