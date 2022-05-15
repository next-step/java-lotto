package lotto.view;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ", ";
    private static final String PAYMENT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String BEFORE_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String IS_NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Game createGameByAuto() {
        return Game.pay(getPrice());
    }

    public static Game createGameByManual() {
        Number price = getPrice();

        ResultView.print();
        ResultView.print(MANUAL_COUNT_MESSAGE);
        Number manualCount = numberValue();

        ResultView.print();
        ResultView.print(MANUAL_LOTTO_NUMBER_MESSAGE);
        List<Lotto> lottoList = LongStream
                .range(Number.of().longValue(), manualCount.longValue())
                .mapToObj(plain -> getLotto(stringValue()))
                .collect(Collectors.toList());

        return Game.pay(price, lottoList);
    }

    public static Lotto getBeforeLotto() {
        ResultView.print();
        ResultView.print(BEFORE_LOTTO_MESSAGE);

        return getLotto(stringValue());
    }

    public static Number getBonusNumber() {
        ResultView.print(BONUS_NUMBER_MESSAGE);

        return numberValue();
    }

    public static Number numberValue() {
        String stringValue = Optional.ofNullable(stringValue())
                .filter(isNumber())
                .orElseThrow(() -> new IllegalArgumentException(IS_NOT_NUMBER_MESSAGE));
        long value = Long.parseLong(stringValue);

        return Number.of(value);
    }

    public static String stringValue() {
        return SCANNER.nextLine();
    }

    private static Predicate<String> isNumber() {
        return value -> !value.isBlank() && value.chars().boxed().allMatch(c -> '0' <= c && c <= '9');
    }

    private static Number getPrice() {
        ResultView.print(PAYMENT_MESSAGE);

        return numberValue();
    }

    private static Lotto getLotto(String plainLotto) {
        List<Integer> values = Stream
                .of(plainLotto.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Lotto.manual(values);
    }
}
