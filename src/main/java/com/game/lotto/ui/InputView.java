package com.game.lotto.ui;

import com.game.lotto.count.TicketCount;
import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.SelectedLottoNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WINNER_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String TICKET_NUMBER_STRING_INPUT_SEPARATOR = ",";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static Money inputPrice() {
        return new Money(inputNumber(INPUT_PRICE_MESSAGE));
    }

    public static LottoNumber inputBonusNumber() {
        return new LottoNumber(inputNumber(INPUT_BONUS_NUMBER_MESSAGE));
    }

    public static TicketCount inputManualLottoCount() {
        return new TicketCount(inputNumber(INPUT_MANUAL_LOTTO_COUNT_MESSAGE));
    }

    public static int inputNumber(String inputMessage) {
        System.out.println(inputMessage);
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다! 숫자와 콤마만 입력해주세요!");
        }
    }

    public static List<LottoNumber> inputLastWinnerNumber() {
        return inputLottoNumber(INPUT_LAST_WINNER_NUMBER_MESSAGE);
    }

    public static List<LottoNumber> inputLottoNumber(String message) {
        String inputString = inputString(message);
        return getLottoNumbers(inputString);
    }

    public static List<SelectedLottoNumbers> inputManualLottoNumber(TicketCount ticketCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
        List<SelectedLottoNumbers> totalSelectedManualLottoNumbers = new ArrayList<>();
        for (int index = 0; index < ticketCount.getCount(); index++) {
            totalSelectedManualLottoNumbers.add(new SelectedLottoNumbers(inputLottoNumber()));
        }
        return totalSelectedManualLottoNumbers;
    }

    public static List<LottoNumber> inputLottoNumber() {
        String inputString = inputString();
        return getLottoNumbers(inputString);
    }

    public static String inputString() {
        return new Scanner(System.in).nextLine();
    }

    private static List<LottoNumber> getLottoNumbers(String inputString) {
        try {
            return Arrays.stream(inputString.split(TICKET_NUMBER_STRING_INPUT_SEPARATOR))
                    .map(x -> new LottoNumber(Integer.parseInt(x.trim())))
                    .collect(Collectors.toUnmodifiableList());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 아닙니다! 숫자만 입력해주세요!");
        }
    }

    public static String inputString(String inputMessage) {
        System.out.println(inputMessage);
        return new Scanner(System.in).nextLine();
    }
}
