package lotto.view;

import lotto.utility.Validator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String WINNING_NUMBERS_FORMAT = "^\\d{1,2}(,\\s\\d{1,2}){5}$";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyAmount() {
        int purchaseAmount = 0;

        try {
            System.out.println("구입금액을 입력해 주세요.");
            purchaseAmount = SCANNER.nextInt();
            SCANNER.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }

        return purchaseAmount;
    }

    public static String inputLastWeekWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String lastWeekWinningNumbers = SCANNER.nextLine();
        isValidWinningNumbersInput(lastWeekWinningNumbers);

        return lastWeekWinningNumbers;
    }

    private static void isValidWinningNumbersInput(String lastWeekWinningNumbers) {
        isValidFormat(lastWeekWinningNumbers);

        List<Integer> winningNumbers = Arrays.stream(lastWeekWinningNumbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Validator.isValidNumbers(winningNumbers);
    }

    private static void isValidFormat(String lastWeekWinningNumbers) {
        if (!lastWeekWinningNumbers.matches(WINNING_NUMBERS_FORMAT)) {
            throw new IllegalArgumentException("잘못된 입력형식입니다. 1, 2, 3, 4, 5, 6과 같은 형태로 입력해주세요");
        }
    }

    public static int inputBonusNumber(String lastWeekWinningNumbers) {
        System.out.println("보너스 볼을 입력해주세요.");

        int bonusNumber = SCANNER.nextInt();

        System.out.println();

        isValidBonusNumberInput(lastWeekWinningNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void isValidBonusNumberInput(String lastWeekWinningNumbers, int bonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(lastWeekWinningNumbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("지난 주 당첨 번호와 보너스 볼이 중복되었습니다.");
        }
    }


}
