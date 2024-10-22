package lotto.view;

import java.util.*;

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
        isValidWinningNumberInput(lastWeekWinningNumbers);

        return lastWeekWinningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");

        int bonusNumber = SCANNER.nextInt();

        System.out.println();

        return bonusNumber;
    }

    private static void isValidWinningNumberInput(String lastWeekWinningNumbers) {
        isValidFormat(lastWeekWinningNumbers);

        String[] numbers = lastWeekWinningNumbers.split(", ");
        Set<String> uniqueNumbers = new HashSet<>();

        isValidNumber(numbers, uniqueNumbers);
    }

    private static void isValidFormat(String lastWeekWinningNumbers) {
        if (!lastWeekWinningNumbers.matches(WINNING_NUMBERS_FORMAT)) {
            throw new IllegalArgumentException("잘못된 입력형식입니다. 1, 2, 3, 4, 5, 6과 같은 형태로 입력해주세요");
        }
    }

    private static void isValidNumber(String[] numbers, Set<String> uniqueNumbers) {
        for (String number : numbers) {
            checkNumberRange(number);
            checkDuplicateNumber(number, uniqueNumbers);
        }
    }

    private static void checkNumberRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException("1부터 45 사이의 숫자만 입력 가능합니다.");
        }
    }

    private static void checkDuplicateNumber(String number, Set<String> uniqueNumbers) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("중복된 당첨번호가 입력되었습니다.");
        }
    }
}
