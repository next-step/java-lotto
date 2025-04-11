package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_INTEGER_INPUT_MESSAGE = "정수를 입력해주세요.";
    private static final String INVALID_STRING_INPUT_MESSAGE = "입력 값이 null 이거나 빈 문자열 입니다.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Money getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return new Money(getIntegerInput());
    }

    public static TicketAmount getManualLottoAmount() {
        System.out.println();
        System.out.println(MANUAL_LOTTO_AMOUNT_MESSAGE);
        return new TicketAmount(getIntegerInput());
    }

    public static List<LottoTicket> getManualLottoNumbers(TicketAmount amount) {
        System.out.println();
        System.out.println(MANUAL_LOTTO_TICKET_MESSAGE);
        List<LottoTicket> numbersList = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            String input = getStringInput();
            numbersList.add(new LottoTicket(Parser.splitAndParseToLottoNumberList(input)));
        }
        return numbersList;
    }

    public static LottoTicket getWinningLotto() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = getStringInput();
        return new LottoTicket(Parser.splitAndParseToLottoNumberList(input));
    }

    public static LottoNumber getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return new LottoNumber(getIntegerInput());
    }

    private static int getIntegerInput() {
        validateIntegerInput();
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static String getStringInput() {
        String input = scanner.nextLine();
        validateStringInput(input);
        return input;
    }

    private static void validateIntegerInput() {
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT_MESSAGE);
        }
    }

    private static void validateStringInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_STRING_INPUT_MESSAGE);
        }
    }

}
