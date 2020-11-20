package step2.view;

import java.util.Arrays;
import java.util.Scanner;

import step2.util.ErrorMessage;

public class InputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요";

    private static final int DEFAULT_MONEY = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int money = SCANNER.nextInt();
        validateMoney(money);
        return money / DEFAULT_MONEY;
    }

    static void validateMoney(int money) {
        if (isValidateMoney(money)) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_THOUSAND);
        }
    }

    static boolean isValidateMoney(int money) {
        return money < DEFAULT_MONEY;
    }

    public static String[] getWinningLottoNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String inputWinningLottoNumber = SCANNER.next();
        return splitWinningLottoNumber(inputWinningLottoNumber);
    }

    public static void validateWinningLottoNumber(String[] winningLottoNumbers) {
        if (isValidateWinningLottoNumber(winningLottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR);
        }
    }

    static boolean isValidateWinningLottoNumber(String[] winningLottoNumbers) {
        for (String str : winningLottoNumbers) {
            int convertNumber = Integer.parseInt(str);
            if (convertNumber < MIN_LOTTO_NUMBER || convertNumber > MAX_LOTTO_NUMBER) {
                return true;
            }
        }
        return false;
    }

    public static void validateWinningLottoNumberSize(String[] winningLottoNumbers) {
        if (isValidateWinningLottoNumberSize(winningLottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIZE_ERROR);
        }
    }

    static boolean isValidateWinningLottoNumberSize(String[] winningLottoNumbers) {
        return winningLottoNumbers.length != LOTTO_NUMBER_SIZE;
    }


    public static void validateDuplicatedWinningLottoNumber(String[] winningLottoNumbers) {
        if (isValidateDuplicatedWinningLottoNumber(winningLottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIZE_ERROR);
        }
    }

    static boolean isValidateDuplicatedWinningLottoNumber(String[] winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers).distinct().count() != winningLottoNumbers.length;
    }


    static String[] splitWinningLottoNumber(String inputWinningLottoNumber) {
        return Arrays.stream(inputWinningLottoNumber.split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
