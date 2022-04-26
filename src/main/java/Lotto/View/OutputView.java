package Lotto.View;

import Lotto.Exception.CustomException;
import Lotto.Model.LottoCard;
import Lotto.Model.LottoGame;
import Lotto.Model.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = "\n";

    private OutputView() {
        throw new CustomException("유틸성클래스는 인스턴스 생성을 할 수 없습니다.");
    }

    public static void printBuyCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLottoGame(List<LottoCard> lottoList) {
        for (LottoCard lottoCard : lottoList) {
            System.out.print('[');
            printLottoCard(lottoCard);
            System.out.print(']');
            System.out.print(NEW_LINE);
        }
    }

    public static void printLottoCard(LottoCard lottoCard) {
        System.out.print(lottoCard.getLotto()
                .stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public static void printPrize(LottoGame lottoGame, LottoCard lotto) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Integer> matchCount = lottoGame.earnMatchCount(lotto);

        double totalMoney = 0;
        for (Prize prize : Prize.values()) {
            int match = prize.getCountOfMatch();
            int winningMoney = prize.getWinningMoney();
            int winningCount = (int) matchCount.stream()
                    .filter(w -> w.equals(prize.getCountOfMatch()))
                    .count();

            totalMoney += winningMoney * winningCount;

            System.out.println(match + "개 일치 (" + winningMoney + "원) - " + winningCount + "개");
        }

        System.out.printf("총 수익률은 %.2f입니다.%n", lottoGame.getWinningRate(totalMoney));
    }
}
