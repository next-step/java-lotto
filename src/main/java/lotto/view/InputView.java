package lotto.view;

import static lotto.domain.LottoGameConfig.*;
import lotto.domain.LottoErrorMessage;
import lotto.domain.LottoNumber;

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
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String LOTTO_NUMBER_PATTERN = "([,\\d])+";
    private static final String NUMBER_PATTERN = "([\\d])+";

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static int getInputMoneyAmount(){
        System.out.println(INPUT_MONEY_MESSAGE);

        String inputMoneyAmount = scanner.next();

        validateInputMoneyAmount(inputMoneyAmount);

        validateMinMoneyAmount(Integer.parseInt(inputMoneyAmount));

        return Integer.parseInt(inputMoneyAmount);

    }

    public static int getManualLottoTicketCount(int gameMoney){
        System.out.println(INPUT_MANUAL_TICKET);

        String inputManualTicketCount = scanner.next();

        validateManualLottoTicketCount(gameMoney, inputManualTicketCount);

        return Integer.parseInt(inputManualTicketCount);
    }

    public static List<List<LottoNumber>> getManualLottoNumbers(int manualTicketCount){
        System.out.println(INPUT_MANUAL_NUMBER);
        return  IntStream.range(0, manualTicketCount)
                .mapToObj(i-> validateManualLottoTicket(scanner.next())).collect(Collectors.toList());
    }

    private static List<LottoNumber> validateManualLottoTicket(String manualTicketValue) {
        if (!manualTicketValue.matches(LOTTO_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
        }

        return parseLottoNumber(splitLottoNumber(manualTicketValue));
    }

    private static List<LottoNumber> parseLottoNumber(String[] splitLottoNumber) {
        List<LottoNumber> parsedLottoNumberList = new ArrayList<>();
        Arrays.stream(splitLottoNumber).forEach(number -> parsedLottoNumberList.add(new LottoNumber(Integer.parseInt(number))));
        return parsedLottoNumberList;
    }

    private static void validateManualLottoTicketCount(int gameMoney, String inputManualTicketCount) {

        int availableGameCount = gameMoney/LOTTO_GAME_MONEY_UNIT;

        if (!inputManualTicketCount.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_INPUT_MANUAL_TICKET.getErrorMessage());
        }

        if(availableGameCount < Integer.parseInt(inputManualTicketCount)){
            throw new IllegalArgumentException(LottoErrorMessage.OVER_MANUAL_TICKET_COUNT.getErrorMessage());
        }
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

    public static List<LottoNumber> splitLastWinningNumbers(String lastWinningNumbers) {
        List<LottoNumber> lastWinningNumberList = new ArrayList<>();
        Arrays.stream(validateLottoNumbers(lastWinningNumbers))
                .forEach(i -> lastWinningNumberList.add(new LottoNumber(Integer.parseInt(i.trim()))));
        return lastWinningNumberList;
    }

    private static String[] splitLottoNumber(String lastWinningNumbersInput) {
        return lastWinningNumbersInput.split(LOTTO_NUMBER_DELIMITER);
    }

    public static String[] validateLottoNumbers(String lastWinningNumbersInput) {
        if (!lastWinningNumbersInput.matches(LOTTO_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
        }

        return splitLottoNumber(lastWinningNumbersInput);
    }

    public static void validateBonusNumber(String bonusNumberValue) {
        if (!bonusNumberValue.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
        }
    }

    public static LottoNumber parseBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);

        return new LottoNumber(Integer.parseInt(bonusNumber));
    }
}
