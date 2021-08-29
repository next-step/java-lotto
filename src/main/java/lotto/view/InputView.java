package lotto.view;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public int receivePurchaseMoney() {
        return receiveNumber("구입금액을 입력해 주세요.");
    }

    public int receiveManualLottoCount() {
        return receiveNumber("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public String[] receiveManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] manualLottoNumbers = new String[manualLottoCount];
        IntStream.range(0, manualLottoCount)
                .forEach(index -> manualLottoNumbers[index] = scanner.nextLine());
        return manualLottoNumbers;
    }

    public String receiveWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int receiveBonusNumber() {
        return receiveNumber("보너스 볼을 입력해 주세요.");
    }

    private int receiveNumber(String message) {
        String input;
        System.out.println(message);
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    private boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
