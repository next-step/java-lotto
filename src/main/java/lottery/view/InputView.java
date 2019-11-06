package lottery.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottery.LottoConstants;

public class InputView {

    private static final String INPUT_DELIMITER = ", ";
    private static Scanner scanner = new Scanner(System.in);

    public static int payAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        return purchaseAmount;
    }

    public static List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return checkWinNumbersInput(input);
    }

    private static List<Integer> checkWinNumbersInput(String input) {
        List<Integer> numbers = Arrays.stream(input.split(INPUT_DELIMITER))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        if (!isValidSize(numbers.size())) {
            throw new IllegalArgumentException("올바른 로또 번호 개수가 아닙니다.");
        }
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.");
        }
        return numbers;
    }

    private static boolean isValidSize(int size) {
        return size == LottoConstants.LOTTO_TICKER_SIZE;
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return LottoConstants.LOTTO_NUMBERS.containsAll(numbers);
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return checkBonusNumberInput(bonusNumber);
    }

    private static int checkBonusNumberInput(int bonusNumber) {
        if (!isValidNumbers(Collections.singletonList(bonusNumber))) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.");
        }

        return bonusNumber;
    }
}
