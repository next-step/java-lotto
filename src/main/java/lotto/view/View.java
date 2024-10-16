package lotto.view;

import lotto.domain.Winning;
import lotto.domain.Lotto;
import lotto.dto.WinningResult;

import java.util.List;
import java.util.Scanner;

public class View {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String SEPARATOR = System.lineSeparator();
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String OUTPUT_PURCHASE_LOTTOS = "개를 구매했습니다.";
    public static final String OUTPUT_WINNING_RESULT = SEPARATOR + "당첨 통계" + SEPARATOR + "---------" + SEPARATOR;
    public static final String OUTPUT_MATCH_THREE = "개 일치 (5000원)- ";
    public static final String OUTPUT_MATCH_FOUR = "개 일치 (50000원)- ";
    public static final String OUTPUT_MATCH_FIVE = "개 일치 (1500000원)- ";
    public static final String OUTPUT_MATCH_SIX = "개 일치 (2000000000원)- ";
    public static final String OUTPUT_WINNING_COUNT = "개" + SEPARATOR;
    public static final String OUTPUT_TOTAL_PREFIX = "총 수익률은 ";
    public static final String OUTPUT_TOTAL_SUFFIX = "입니다.";

    public String inputMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return SCANNER.nextLine();
    }

    public List<Lotto> outputLottos(final List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append(OUTPUT_PURCHASE_LOTTOS).append(SEPARATOR);
        for (Lotto lotto : lottos) {
            sb.append(lotto).append(SEPARATOR);
        }
        System.out.println(sb);
        return lottos;
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

    public void outputWinningResult(final WinningResult winningResult) {
        List<Winning> winnings = winningResult.getCounts();

        System.out.println(OUTPUT_WINNING_RESULT +
                winnings.get(0).getCountMatching() + OUTPUT_MATCH_THREE + winnings.get(0).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(1).getCountMatching() + OUTPUT_MATCH_FOUR + winnings.get(1).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(2).getCountMatching() + OUTPUT_MATCH_FIVE + winnings.get(2).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(3).getCountMatching() + OUTPUT_MATCH_SIX + winnings.get(3).getCountWinning() + OUTPUT_WINNING_COUNT +
                OUTPUT_TOTAL_PREFIX + winningResult.getTotalReturn() + OUTPUT_TOTAL_SUFFIX);
    }
}
