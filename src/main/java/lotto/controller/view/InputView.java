package lotto.controller.view;

import lotto.utils.IntegerParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int START_INCLUSIVE = 0;
    private static final int MIN_MANUAL_LOTTO_LINE_COUNT = 1;

    private InputView() {
    }

    public static int getWon() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNextInt();
    }

    public static List<String> getManualLottoLines() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return getManualLottoLines(getNextInt());
    }

    private static List<String> getManualLottoLines(int count) {
        if (count < MIN_MANUAL_LOTTO_LINE_COUNT) {
            return new ArrayList<>();
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(START_INCLUSIVE, count)
                .mapToObj(index -> getNextLine())
                .collect(Collectors.toList());
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getNextLine();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getNextInt();
    }

    private static int getNextInt() {
        return IntegerParser.parseInt(getNextLine());
    }

    private static String getNextLine() {
        return SCANNER.nextLine();
    }
}
