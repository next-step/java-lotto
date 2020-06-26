package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualLottoInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final int numberOfManual;
    private final List<String> stringManualNumbers;

    private ManualLottoInputView(int numberOfManual) {
        this.numberOfManual = numberOfManual;
        this.stringManualNumbers = getStringManualNumbers(numberOfManual);
    }

    public static ManualLottoInputView enterManualLottoInput() {
        return new ManualLottoInputView(getNumberOfManualInput());
    }

    private static int getNumberOfManualInput() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private List<String> getStringManualNumbers(final int numberOfManual) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        consumeNewLine();

        final List<String> stringManualNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfManual; i++) {
            final String manualNumber = getManualNumberInput();
            stringManualNumbers.add(manualNumber);
        }
        return stringManualNumbers;
    }

    private static String getManualNumberInput() {
        return SCANNER.nextLine();
    }

    public int getNumberOfManual() {
        return numberOfManual;
    }

    public List<String> getStringManualNumbers() {
        return stringManualNumbers;
    }

    private void consumeNewLine() {
        SCANNER.nextLine();
    }

}
