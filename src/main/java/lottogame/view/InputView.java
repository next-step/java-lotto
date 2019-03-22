package lottogame.view;

import lottogame.domain.*;
import lottogame.inputgetter.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {
    public static final String NUMBER_DELIMETER = ",";

    private static Scanner scanner = new Scanner(System.in);

    public InputView(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static PurchaseAmount getPurchaseAmount() {
        return new PurchaseAmountInputGetter().get();
    }

    public static PurchaseCount getPurchaseCount(long count) {
        return new PurchaseCountInputGetter().get(count);
    }

    public static List<LottoNumberPackage> getManualNumbers(long count) {
       return new ManualNumbersInputGetter().get(count);
    }

    public static LottoNumberPackage getWinningNumbers() {
        return new WinningNumberInputGetter().get();
    }

    public static WinningInfo getWinningInfoByBonusNumber(LottoNumberPackage winningNumbers) {
        return new BonusNumberInputGetter().get(winningNumbers);
    }

    public static InputLine getInputLine() {
        String inputLine = scanner.nextLine();

        return Optional.ofNullable(inputLine)
                        .map(InputLine::new)
                        .get();
    }
}