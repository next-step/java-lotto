package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanInt();
    }

    public static Lotto askLottoWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(parseInt(asList(split(scanner.nextLine()))));
    }

    private static int scanInt() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static String[] split(String winningNumbers) {
        return winningNumbers.split(", |,");
    }

    private static List<String> asList(String[] winningNumbers) {
        return Arrays.asList(winningNumbers);
    }

    private static List<Integer> parseInt(List<String> winningNumbers) {
        return winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static LottoNumber askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(scanInt());
    }
}
