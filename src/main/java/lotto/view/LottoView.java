package lotto.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoView {

    public static final String INPUT_LOTTO_DELIMITER = ",";
    public static final String OUTPUT_LOTTO_DELIMITER = ", ";
    private final Scanner scanner = new Scanner(System.in);

    public int readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().strip());
    }

    public List<Integer> readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLotto();
    }

    private List<Integer> readLotto() {
        String[] elements = scanner.nextLine().split(INPUT_LOTTO_DELIMITER);
        return Arrays.stream(elements)
                .map(element -> Integer.parseInt(element.strip()))
                .collect(Collectors.toList());
    }

    public int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().strip());
    }

    public int readManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().strip());
    }

    public List<List<Integer>> readManualLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(readLotto());
        }
        return lottos;
    }

    public void printLottoCount(int manualCount, int AutomaticCount) {
        String output = MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.", manualCount, AutomaticCount);
        System.out.println(output);
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
                .collect(Collectors.joining(OUTPUT_LOTTO_DELIMITER));

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
        if (lottoMatch.isBonus()) {
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
