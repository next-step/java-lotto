package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 로또의 입출력 담당
public class LottoProcessor {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println((purchaseAmount / Lotto.AMOUNT) + "개를 구매했습니다.");
        return purchaseAmount;
    }

    public static void printLotto(Lotto lotto) {
        lotto.generateLottoNumbers();
        lotto.printNumbers();
    }

    public static void getWinningStats(Lotto lotto) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumbers = SCANNER.nextLine();

        LottoWinningStats lottoWinningStats = new LottoWinningStats(getWinningNumbers(inputNumbers), lotto);
        lottoWinningStats.calculateWinningStats();
        lottoWinningStats.calculateWinningCounts();
        lottoWinningStats.printWinningCounts();

        System.out.println("총 수익률은 " + lottoWinningStats.getYield() + "입니다.");
    }

    private static List<Integer> getWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");
        List<Integer> winningNumbers = Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
        return winningNumbers;
    }
}
