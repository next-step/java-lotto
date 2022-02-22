package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lotto.util.Console;

public class InputView {

    private InputView() {
    }

    public static int readPrice() {
        OutputView.printRequestLottoPrice();
        try {
            return Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readPrice();
        }
    }

    public static String readWinningNumber() {
        OutputView.printWinningNumberBefore();
        Scanner sc = new Scanner(System.in);
        try {
            String winningNumber = sc.nextLine();
            return winningNumber;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readWinningNumber();
        }
    }

    public static int readBonusNumber() {
        OutputView.printBonusBallNumber();
        try {
            return Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readBonusNumber();
        }
    }

    public static int readManualLottoNumberCount() {
        try {
            return Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readManualLottoNumberCount();
        }
    }

    public static List<String> readManualLottoNumber() {
        OutputView.printManualLottoNumberCount();
        int manualCount = InputView.readManualLottoNumberCount();

        if(manualCount <= 0) return Collections.unmodifiableList(new ArrayList<>());

        OutputView.printManualLottoNumber();

        List<String> manualLottos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(sc.nextLine());
        }
        return manualLottos;
    }

}
