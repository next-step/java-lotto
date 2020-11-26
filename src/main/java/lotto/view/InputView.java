package lotto.view;

import static lotto.domain.LottoGameConfig.*;
import lotto.domain.LottoErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER= "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_MONEY_PATTERN = "(\\d+)";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "([,\\d])+";
    private static final String BONUS_NUMBER_PATTERN = "([\\d])+";

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static int getInputMoneyAmount(){
        System.out.println(INPUT_MONEY_MESSAGE);

        String inputMoneyAmount = scanner.next();

        validateInputMoneyAmount(inputMoneyAmount);

        validateMinMoneyAmount(Integer.parseInt(inputMoneyAmount));

        return Integer.parseInt(inputMoneyAmount);

    }

    public static int getManualLottoTicketCount(){
        System.out.println(INPUT_MANUAL_TICKET);

        String inputManualTicketCount = scanner.next();

        return Integer.parseInt(inputManualTicketCount);
    }

    public static List<String> getManualLottoNumbers(int manualTicketCount){
        System.out.println(INPUT_MANUAL_NUMBER);
        return  IntStream.range(0, manualTicketCount)
                .mapToObj(i->scanner.next()).collect(Collectors.toList());
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

    public static String getInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);

        String bonusNumber = scanner.next();

        return bonusNumber;
    }

    public static List<Integer> splitLastWinningNumbers(String lastWinningNumbers) {
        List<Integer> lastWinningNumberList = new ArrayList<>();
        Arrays.stream(validateLastWinningNumbers(lastWinningNumbers)).forEach(i -> lastWinningNumberList.add(Integer.parseInt(i.trim())));
        return lastWinningNumberList;
    }

    private static String[] splitWinningNumber(String lastWinningNumbersInput) {
        return lastWinningNumbersInput.split(WINNING_NUMBER_DELIMITER);
    }

    public static String[] validateLastWinningNumbers(String lastWinningNumbersInput) {
        if (!lastWinningNumbersInput.matches(WINNING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }

        return splitWinningNumber(lastWinningNumbersInput);
    }

    public static int validateBonusNumber(String bonusNumberValue) {
        if (!bonusNumberValue.matches(BONUS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
        }

        return Integer.parseInt(bonusNumberValue);
    }

}
