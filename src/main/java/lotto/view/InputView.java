package lotto.view;

import lotto.exception.InvalidMoneyUnitException;
import lotto.model.LottoNumber;
import lotto.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DEFAULT_DELIMITER = ",";

    private static final String INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.";

    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public Money readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        long value = readNumber();
        validateMoneyUnit(value);
        return new Money(value);
    }

    private void validateMoneyUnit(long value) {
        if (!meetsMoneyUnit(value)) {
            throw new InvalidMoneyUnitException(value);
        }
    }

    private boolean meetsMoneyUnit(long value) {
        return value % 1_000 == 0;
    }

    private long readNumber() {
        return Long.parseLong(readLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String readNumbers = readLine().replace(" ", "");
        return convertNumbers(readNumbers);
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private List<Integer> convertNumbers(String readNumbers) {
        return Arrays.stream(readNumbers.split(DEFAULT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoNumber readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return new LottoNumber((int) readNumber());
    }

}
