package lotto.ui;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lotto.error.ErrorMessage;
import lotto.lotto.Lotto;
import lotto.shop.Money;

public class InputView {
    public static final String NUMBER_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money inputMoneyAmount() {
        String input = SCANNER.nextLine();
        return new Money(toInteger(input));
    }

    public static List<Lotto> inputLottos(int selfLottoQuantity) {
        return IntStream.range(0, selfLottoQuantity)
                .mapToObj(i -> new Lotto(InputView.inputLottoNumbers()))
                .collect(Collectors.toList());
    }

    public static List<Integer> inputLottoNumbers() {
        String input = SCANNER.nextLine();
        String[] lottoNumbers = input.split(NUMBER_DELIMITER);
        checkLottoNumbers(lottoNumbers);
        return Stream.of(lottoNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private static void checkLottoNumbers(String[] lottoInputNumbers) {
        if (lottoInputNumbers.length != Lotto.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER);
        }
    }

    public static int inputNumber() {
        return toInteger(SCANNER.nextLine());
    }
}