package lotto.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.*;

public class LottoView {

    public static final String NUMBER_DELIMITER = ", ";
    public static final int FIVE_MATCH_COUNT = 5;
    private final Scanner scanner = new Scanner(System.in);

    public int readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public List<Integer> readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] elements = scanner.nextLine().split(NUMBER_DELIMITER);
        return Arrays.stream(elements)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        String output = lotto.getLotto().stream()
                        .map(LottoNumber::getLottoNumber)
                        .map(String::valueOf)
                        .collect(Collectors.joining(NUMBER_DELIMITER));

        System.out.println("[" + output + "]");
    }

    public void printResults(Map<LottoMatch, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoMatch lottoMatch : resultMap.keySet()) {
            printResult(lottoMatch, resultMap.get(lottoMatch));
        }
    }

    private void printResult(LottoMatch lottoMatch, int count) {
        int matchCount = lottoMatch.getMatchCount();
        int prize = lottoMatch.getPrize();
        if (matchCount == FIVE_MATCH_COUNT && lottoMatch.isBonus()) {
            String result = MessageFormat.format("{0}개 일치, 보너스 볼 일치({1}원) - {2}개", matchCount, prize, count);
            System.out.println(result);
            return;
        }
        String output = MessageFormat.format("{0}개 일치 ({1}원) - {2}개", matchCount, prize, count);
        System.out.println(output);
    }

    public void printProfitRate(float profitRate) {
        String output = MessageFormat.format("총 수익률은 {0}입니다", String.format("%.2f", profitRate));
        System.out.println(output);
    }
}
