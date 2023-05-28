package view.result;

import model.LotteryStatics;
import model.Lotto;
import model.Lottos;
import model.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoInfo(Lottos passiveLottos, Lottos autoLottos) {
        resultBuyInputCount(passiveLottos.getLottos().size(), autoLottos.getLottos().size());
        getLotto(passiveLottos.getLottos());
        getLotto(autoLottos.getLottos());
    }

    private static void resultBuyInputCount(int passiveCount, int autoCount) {
        System.out.println("수동으로 " + passiveCount + "장, 자동으로" + autoCount + " 장을 구매했습니다.");
    }

    private static void getLotto(List<Lotto> Input) {
        for (Lotto lotto : Input) {
            System.out.println(lotto.getWinNumIntegerType());
        }
    }

    public static void getEndingMessage() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printStatics(LotteryStatics lotteryStatics) {
        printWinnerMessage(lotteryStatics.getLotteryStatics());
        printTotalGross(lotteryStatics.getGross());
    }

    private static void printWinnerMessage(Map<Rank, Integer> winCount) {
        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, Collections.reverseOrder()); // 역순으로 정렬

        for (Rank rank : ranks) {
            int count = winCount.getOrDefault(rank, 0);
            if (rank != rank.MISS) {
                System.out.println(printLottoResult(rank, count));
            }

        }
    }

    private static String printLottoResult(Rank rank, int count) {

        if (rank == rank.SECOND) {
            return getSecondMessage(rank, count);
        }

        return getMessage(rank, count);

    }

    private static String getSecondMessage(Rank rank, int count) {

        return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) - " + count + "개";

    }

    private static String getMessage(Rank rank, int count) {

        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + count + "개";

    }

    private static void printTotalGross(double gross) {
        DecimalFormat df = new DecimalFormat("#.##");
        String message = "총 수익률은 " + df.format(gross) + "입니다. (기준이 1이기 때문에 결과적으로 ";

        gainMessage(gross, message);
        nothingMessage(gross, message);
        lostMessage(gross, message);
    }

    private static void lostMessage(double gross, String message) {
        if (gross < 1) {
            message += "손해이라는 의미임)";
            System.out.println(message);
            return;
        }
    }

    private static void nothingMessage(double gross, String message) {
        if (gross == 1) {
            message += "본전이라는 의미임)";
            System.out.println(message);
            return;
        }
    }

    private static void gainMessage(double gross, String message) {
        if (gross > 1) {
            message += "이득이라는 의미임)";
            System.out.println(message);
            return;
        }
    }
}
