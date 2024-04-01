package lottogame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lottogame.domain.LottoFactory;
import lottogame.domain.Money;
import lottogame.domain.Number;

public class InputView {

    private static final String REQUEST_MONEY = "구입금액을 입력해주세요.";
    private static final String REQUEST_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String REQUEST_MANUAL_COUNT_OF_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String REQUEST_MULTIPLE_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INVALID_INPUT_MANUAL_LOTTOS = "로또 번호는 6자리여야 합니다. 입력한 번호는 %d자리 입니다.";
    public static final String INVALID_INPUT_MANUAL_LOTTOS_COUNT = "입력한 수동 로또수가 구입 가능한 로또수 보다 큽니다.";

    private InputView() {
    }

    public static Money requestMoney() {
        System.out.println(REQUEST_MONEY);
        return Money.from(Integer.parseInt(inputValue()));
    }

    public static List<Integer> requestWinningLotto() {
        try {
            System.out.println(REQUEST_WINNING_LOTTO);
            return convertNumbersToList();
        } catch (IllegalArgumentException e) {
            return requestWinningLotto();
        }

    }

    public static Number requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Number.from(inputValue());
    }

    public static Number requestCountOfManualLottos(Number countOfLottos) {
        try {
            System.out.println(REQUEST_MANUAL_COUNT_OF_LOTTO);
            Number number = inputNumber();
            if (countOfLottos.isLessThan(number)) {
                throw new IllegalArgumentException(INVALID_INPUT_MANUAL_LOTTOS_COUNT);
            }
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            return requestCountOfManualLottos(countOfLottos);
        }
    }

    public static List<List<Integer>> requestMultipleManualLottos(Number count) {
        System.out.println(REQUEST_MULTIPLE_MANUAL_LOTTOS);
        List<List<Integer>> multipleManualLottos = new ArrayList<>();
        while(count.isPositive()) {
            multipleManualLottos.add(requestManualLottos());
            count = count.decrease();
        }
        return multipleManualLottos;
    }

    private static List<Integer> requestManualLottos() {
        try {
            return convertNumbersToList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " 다시 입력해주세요.");
            return requestManualLottos();
        }
    }

    private static List<Integer> convertNumbersToList() {
        List<Integer> numbers =  Stream.of(inputValue().split(","))
                .map(InputView::convertStringToInt)
                .collect(Collectors.toList());

        if (!LottoFactory.isValidLottosSize(numbers.size())) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_MANUAL_LOTTOS, numbers.size()));
        }
        return numbers;
    }

    private static int convertStringToInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(text + "는 양수가 아닙니다.");
        }
    }

    private static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Number inputNumber() {
        return Number.from(inputValue());
    }
}
