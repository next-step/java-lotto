package lotto.view;

import static lotto.domain.LottoGameConfig.*;
import lotto.domain.LottoErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER= "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MONEY_PATTERN = "(\\d+)";

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static int getInputMoneyAmount(){
        System.out.println(INPUT_MONEY_MESSAGE);

        String inputMoneyAmount = scanner.next();

        validateInputMoneyAmount(inputMoneyAmount);

        validateMinMoneyAmount(Integer.parseInt(inputMoneyAmount));

        return Integer.parseInt(inputMoneyAmount);

    }

    private static void validateInputMoneyAmount(String inputMoneyAmount) {
        if(!inputMoneyAmount.matches(INPUT_MONEY_PATTERN)){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_INPUT_MONEY.getErrorMessage());
        }
    }

    private static void validateMinMoneyAmount(int inputMoneyAmount) {
        if(inputMoneyAmount < LOTTO_GAME_MONEY_UNIT){
            throw new IllegalArgumentException(LottoErrorMessage.UNDER_MIN_INPUT_MONEY.getErrorMessage());
        }
    }


    public static String getInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);

        String winningNumbers = scanner.next();

        return winningNumbers;

    }
}
