package lotto.view;

import lotto.lotto.LottoTicket;
import lotto.lotto.LottoTickets;
import lotto.money.Money;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.money.Money.ZERO_VALUE;

public class InputView {
    private static final String INPUT_PAYMENT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBER_OF_MANUAL_LOTTO_STATEMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_STATEMENT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_STATEMENT = "보너스 볼을 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static Money inputPayment() {
        printStatement(INPUT_PAYMENT_STATEMENT);

        return Money.from(getInt());
    }

    public static LottoTickets inputManualLottoTickets() {
        int numberOfManualLotto = inputNumberOfManualLotto();

        printStatement(INPUT_MANUAL_LOTTO_NUMBERS_STATEMENT);


        return IntStream.rangeClosed(ZERO_VALUE, numberOfManualLotto)
                .mapToObj(i -> inputLottoNumbers())
                .map(LottoNumbers::from)
                .map(LottoTicket::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
    }

    private static int inputNumberOfManualLotto() {
        printStatement(INPUT_NUMBER_OF_MANUAL_LOTTO_STATEMENT);

        return getInt();
    }

    public static WinningNumbers inputWinningNumbers() {
        printStatement(INPUT_WINNING_NUMBERS_STATEMENT);
        List<LottoNumber> lottoNumbers = inputLottoNumbers();

        printStatement(INPUT_BONUS_NUMBER_STATEMENT);
        LottoNumber bonusNumber = LottoNumber.from(getInt());

        return WinningNumbers.of(lottoNumbers, bonusNumber);
    }

    private static List<LottoNumber> inputLottoNumbers() {
        return Arrays.stream(readNumbers())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int getInt() {
        return Integer.parseInt(
                SCANNER.nextLine()
                        .trim()
        );
    }

    private static String[] readNumbers() {
        return SCANNER.nextLine()
                .split(NUMBER_DELIMITER);
    }
}
