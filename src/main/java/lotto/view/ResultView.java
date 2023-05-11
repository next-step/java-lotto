package lotto.view;

import lotto.domain.lottocreator.Lotto;
import lotto.domain.Lottos;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningCount;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printCostOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumbersOfLotto(int manualLottos, int autoLottos) {
        System.out.println("수동으로 " + manualLottos + "개, 자동으로 " + autoLottos + "개를 구매했습니다.");
    }

    public static void printWinningNumber() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> ResultView.printLotto(lotto));
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics(Map<WinningCount, Integer> statistics, List<WinningCount> rewardCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        rewardCount.stream().forEach(count -> printWinningCountAndReward(statistics, count));
    }

    public static void printWinningCountAndReward(Map<WinningCount, Integer> statistics, WinningCount winningCount) {
        printWinningCount(winningCount);
        System.out.println(" (" + Rank.of(winningCount) +"원) - " + statistics.getOrDefault(winningCount, 0) + "개");
    }

    public static void printWinningCount(WinningCount winningCount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winningCount.getCount() + "개 일치");
        if (winningCount.getIsMatchBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        System.out.print(stringBuilder);
    }

    public static void printLottoRate(String rate) {
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printNumberOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printManualLottosNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

}
