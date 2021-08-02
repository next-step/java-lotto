package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ManualLottos;
import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_STATEMENT = "보너스 볼을 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";
    private static final int MIN_COUNT_MANUAL_LOTTO = 0;

    private InputView() {
    }

    public static Money inputPurchaseMoney() {
        printStatement(INPUT_PURCHASE_MONEY);

        return Money.of(changeIntInputValue());
    }

    public static int inputNumberOfManualLotto() {
        printStatement(INPUT_COUNT_OF_MANUAL_LOTTO);

        return changeIntInputValue();
    }

    public static ManualLottos inputManualLottoTickets(int count) {
        printStatement(INPUT_MANUAL_LOTTO_NUMBERS);

        return IntStream.range(MIN_COUNT_MANUAL_LOTTO, count)
                .mapToObj(i -> getLottoNumbers())
                .map(LottoNumbers::of)
                .map(Lotto::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), ManualLottos::of));
    }


    public static WinningLotto inputWinningNumbers() {
        printStatement(INPUT_WINNING_NUMBERS_STATEMENT);
        List<LottoNumber> lottoNumbers = getLottoNumbers();

        printStatement(INPUT_BONUS_NUMBER_STATEMENT);
        LottoNumber bonusNumber = LottoNumber.of(changeIntInputValue());

        printStatement(System.lineSeparator());

        return WinningLotto.of(LottoNumbers.of(lottoNumbers), bonusNumber);
    }

    private static List<LottoNumber> getLottoNumbers() {
        return Arrays.stream(readNumbers())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int changeIntInputValue() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static String[] readNumbers() {
        return scanner.nextLine().split(NUMBER_DELIMITER);
    }

}
