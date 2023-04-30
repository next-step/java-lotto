package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1_000;
    private static final String DELIMITER = ",";

    public static int calculateLottoCount() {
        System.out.println("구입금액을 입력해 주세요.(1000원 단위)");
        int money = consoleIntInput();
        return money / LOTTO_PRICE;
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return consoleIntInput();
    }
    public static int inputManualLottoCount(int totalLottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = consoleIntInput();

        while (manualLottoCount > totalLottoCount) {
            System.out.println("수동 구매 수는 총 금액을 초과할 수 없습니다. 다시 입력해 주세요.");
            manualLottoCount = consoleIntInput();
        }
        return manualLottoCount;
    }

    public static List<List<Integer>> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.add(inputLottoNumbers());
        }
        return manualLottoNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = SCANNER.nextLine();

        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return consoleIntInput();
    }

    private static List<Integer> inputLottoNumbers() {
        String manualLottoInput = SCANNER.nextLine();
        return Arrays.stream(manualLottoInput.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int consoleIntInput() {
        int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }
}
