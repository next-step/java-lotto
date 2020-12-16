package lotto.view;

import lotto.util.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_LOTTO_BUY_MONEY_MESSAGE = "LOTTO 구입 금액을 입력해주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 LOTTO 번호를 입력해주세요.";
    private static final String INVALID_INPUT_ERROR = "문자가 입력되었습니다. 숫자만 입력해주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println(INPUT_LOTTO_BUY_MONEY_MESSAGE);
        return inputNumber();
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        return inputLottoNumbers();
    }

    private static List<Integer> inputLottoNumbers() {
        String text = SCANNER.nextLine();
        System.out.println();
        return StringSplitter.splitText(text);
    }

    private static int inputNumber() {
        int number;
        try {
            number = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_INPUT_ERROR);
        }
        System.out.println();

        return number;
    }

    public static int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return inputNumber();
    }

}
