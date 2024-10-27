package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoFactory;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static Scanner scanner;

    public static void initiateScanner() {
        scanner = new Scanner(System.in);
    }

    public static String scanWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static LottoChecker createLottoCheckerWithScan() {
        String winnerNumbers = scanWinnerNumbers();
        return new LottoChecker(null, createLottoWithScan(winnerNumbers));
    }

    public static Lotto createLottoWithScan(String numberString) {
        String[] numbers = numberString.split(", ");

        return LottoFactory.createLotto(
                Arrays.stream(numbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
    }
}
