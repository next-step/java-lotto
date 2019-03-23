package lottogame.view;

import lottogame.domain.*;
import lottogame.inputgetter.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ConsoleInputView {
    public static final String NUMBER_DELIMITER = ",";

    private static Scanner scanner = new Scanner(System.in);

    public ConsoleInputView(Scanner scanner) {
        ConsoleInputView.scanner = scanner;
    }

    public static PurchaseAmount getPurchaseAmount() {
        showPurchaseAmountInputMessage();
        return new PurchaseAmount(getInputLine());
    }

    private static void showPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static PurchaseCount getPurchaseCount(long count) {
        showPurchaseCountInputMessage();
        return new PurchaseCount(count, getInputLine());
    }

    private static void showPurchaseCountInputMessage() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static List<LottoNumberPackage> getManualNumbers(long count) {
        showManualNumbersInputMessage();
        return LongStream.rangeClosed(1, count)
                .mapToObj(number -> new LottoNumberPackage(getInputLine()))
                .collect(Collectors.toList());
    }

    private static void showManualNumbersInputMessage() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public static LottoNumberPackage getWinningNumbers() {
        showWinningNumbersInputMessage();
        return new LottoNumberPackage(getInputLine());
    }

    private static void showWinningNumbersInputMessage() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public static WinningInfo getWinningInfoByBonusNumber(LottoNumberPackage winningNumbers) {
        showBonusNumberInputMessage();
        return new WinningInfo(winningNumbers, getInputLine());
    }

    private static void showBonusNumberInputMessage() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
    }

    public static InputLine getInputLine() {
        String inputLine = scanner.nextLine();

        return Optional.ofNullable(inputLine)
                        .map(InputLine::new)
                        .get();
    }
}