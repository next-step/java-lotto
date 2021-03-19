package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.RankingRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        final String QUESTION_FOR_GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
        System.out.println(QUESTION_FOR_GET_PURCHASE_AMOUNT);
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    public void printBought(List<LottoGame> lottoGames) {
        final String SUFFIX = "개를 구매했습니다.";
        System.out.println(lottoGames.size() + SUFFIX);
        for (LottoGame lottoGame : lottoGames) {
            System.out.println(lottoGame.numbers());
        }
    }

    public List<Integer> winningNumber() {
        final String QUESTION_FOR_GET_PURCHASE_AMOUNT = "지난 주 당첨 번호를 입력해 주세요.";
        System.out.println(QUESTION_FOR_GET_PURCHASE_AMOUNT);
        String[] winningNumbers = scanner.nextLine().split(",");

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void printStatsHead() {
        final String STATS_HEAD = "당첨 통계";
        final String HORIZONTAL_LINE = "---------";

        System.out.println(STATS_HEAD);
        System.out.println(HORIZONTAL_LINE);
    }

    public void print(int matchCount, int reward, int winners) {
        System.out.format("%d 개 일치 (%d) - %d개\n", matchCount, reward, winners);
    }

    public void printYield(double yield) {
        System.out.format("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임\n", yield);
    }
}
