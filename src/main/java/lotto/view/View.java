package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.RankingRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final String QUESTION_FOR_GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String SUFFIX = "개를 구매했습니다.";
    private static final String QUESTION_FOR_GET_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String STATS_HEAD = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---------";


    static public int purchaseAmount(Scanner scanner) {
        System.out.println(QUESTION_FOR_GET_PURCHASE_AMOUNT);
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    static public void printBought(List<LottoGame> lottoGames) {
        System.out.println(lottoGames.size() + SUFFIX);
        for (LottoGame lottoGame : lottoGames) {
            System.out.println(lottoGame.numbers());
        }
    }

    static public List<Integer> winningNumber(Scanner scanner) {
        System.out.println(QUESTION_FOR_GET_WINNING_NUMBER);
        String[] winningNumbers = scanner.nextLine().split(",");

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    static public void printStatsHead() {
        System.out.println(STATS_HEAD);
        System.out.println(HORIZONTAL_LINE);
    }

    static public void print(int matchCount, int reward, int winners) {
        System.out.format("%d 개 일치 (%d) - %d개\n", matchCount, reward, winners);
    }

    static public void printYield(double yield) {
        System.out.format("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임\n", yield);
    }
}
