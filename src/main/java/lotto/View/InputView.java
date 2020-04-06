package lotto.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final String INFORMATION_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private final String INFORMATION_BUY_MANUALLY_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final String INFORMATION_BUY_MANUALLY_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private final String INFORMATION_LAST_WEEK_WINNER = "지난 주 당첨 번호를 입력해 주세요.";
    private final String INFORMATION_LAST_WEEK_BONUS = "보너스 볼을 입력해 주세요.";

    private Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static InputView init() {
        return new InputView();
    }

    public int userInstructionAmount() {
        return userInstructionToNumber(INFORMATION_BUY_AMOUNT);
    }

    public List<String> userInstructionManually() {
        int manuallyLottoCount = userInstructionToNumber(INFORMATION_BUY_MANUALLY_COUNT);
        List<String> manualLottoNumbers = new ArrayList<>();

        System.out.println(INFORMATION_BUY_MANUALLY_NUMBERS);
        for (int i = 0; i < manuallyLottoCount; i++) {
            manualLottoNumbers.add(scanner.nextLine());
        }

        return manualLottoNumbers;
    }

    public int userInstructionBonus() {
        return userInstructionToNumber(INFORMATION_LAST_WEEK_BONUS);
    }

    private int userInstructionToNumber(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public String userInstructionWinner() {
        System.out.println(INFORMATION_LAST_WEEK_WINNER);
        return scanner.nextLine();
    }

}