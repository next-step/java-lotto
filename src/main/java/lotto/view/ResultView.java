package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningCount;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printCostOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumbersOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
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
        System.out.println("당첨 통계");
        System.out.println("---------");

        rewardCount.stream().forEach(count -> printWinningCountAndReward(statistics, count));
    }

    public static void printWinningCountAndReward(Map<WinningCount, Integer> statistics, WinningCount count) {
        System.out.println(count + "(" + Rank.of(count) +"원) - " + statistics.getOrDefault(count, 0) + "개");
    }

    public static void printLottoRate(String rate) {
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

}
