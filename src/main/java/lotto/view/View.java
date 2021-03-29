package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final String QUESTION_FOR_GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_FOR_GET_NUMBER_OF_MANUAL_GAMES = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_FOR_GET_MANUAL_NUMBERS ="수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_FOR_GET_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_FOR_GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String STATS_HEAD = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---------";
    private static final Scanner scanner = new Scanner(System.in);

    static public int purchaseAmount() {
        System.out.println(QUESTION_FOR_GET_PURCHASE_AMOUNT);
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    static public int numberOfManualGames() {
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_MANUAL_GAMES);
        int numberOfManaulGames = scanner.nextInt();
        scanner.nextLine();
        return numberOfManaulGames;
    }

    static public List<Integer> winningNumber() {
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

    public static void print(Lotto lotto) {
        System.out.format("수동으로 %d장, 자동으로 %d개를 구매했습니다\n", lotto.numberOfManualGames(), lotto.numberOfGeneratedGames());
        for (LottoGame game : lotto.games()) {
            print(game);
        }
    }

    public static int bonusNumber() {
        System.out.println(QUESTION_FOR_GET_BONUS_NUMBER);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public static void print(Rank rank, int wins) {
        if (rank.matchBonus()) {
            System.out.format("%d 개 일치, 보너스 볼 일치 (%d) - %d개\n", rank.countOfMatch(), rank.prize(), wins);
            return;
        }
        System.out.format("%d 개 일치 (%d) - %d개\n", rank.countOfMatch(), rank.prize(), wins);
    }

    public static List<String> manualGameNumbers(int numberOfManualGames) {
        List<String> manualGameNumbers = new ArrayList<>();
        if (numberOfManualGames == 0)
            return manualGameNumbers;

        for (int i=0; i<numberOfManualGames; i++) {
            System.out.println(QUESTION_FOR_GET_MANUAL_NUMBERS);
            manualGameNumbers.add(scanner.nextLine());
        }

        return manualGameNumbers;
    }

    private static void print(LottoGame game) {
        System.out.println(game.numbers());
    }
}
