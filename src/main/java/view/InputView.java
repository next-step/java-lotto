package view;

import domain.LottoNumber;
import domain.WinningNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ", ";
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE = "구입금액은 숫자만 입력 가능합니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int lottoStart() {
        System.out.println(LOTTO_START_MESSAGE);
        String inputLine = SCANNER.nextLine();
        inputDigitValid(inputLine);
        return Integer.parseInt(inputLine);
    }

    public static WinningNumber winningNumber(String winningNumberString) {
        return new WinningNumber(Arrays.stream(winningNumberString.split(DELIMITER))
                .map(value -> new LottoNumber(Integer.parseInt(value)))
                .collect(Collectors.toList()));
    }

    public static String winningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    private static void inputDigitValid(String inputLine) {
        if(inputLine.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE);
        }
    }

    public static int bonusBall() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        return SCANNER.nextInt();
    }

    public static LottoNumber bonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if(winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
        return lottoNumber;
    }
}
