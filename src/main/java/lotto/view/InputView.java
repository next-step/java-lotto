package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.LottoConstants.*;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    public static final String INPUT_MIN_PRICE_MESSAGE = "금액은 최소" + LOTTO_PRICE + "원 이상 입력이 가능합니다.";
    public static final String INPUT_CORRECT_PRICE_UNIT_MESSAGE = "금액은 " + LOTTO_PRICE + "원 단위로 입력이 가능합니다.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int moneyInput(String message) {
        System.out.println(message);

        try {
            int money = scanNextInt();
            System.out.println(money / LOTTO_PRICE + "개를 구매했습니다.");
            return money;
        } catch (NumberFormatException e) {
            return moneyInput(INPUT_NUMBER_MESSAGE);
        } catch (IllegalArgumentException e) {
            return moneyInput(e.getMessage());
        }
    }

    private int scanNextInt() {
        int nextInt = Integer.parseInt(scanner.nextLine());

        if (nextInt < LOTTO_PRICE) {
            throw new IllegalArgumentException(INPUT_MIN_PRICE_MESSAGE);
        }

        if (nextInt % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_CORRECT_PRICE_UNIT_MESSAGE);
        }

        return nextInt;
    }

    public LottoNumber winnnigNumbersInput() {
        String inputNumbers = scanner.nextLine();
        String[] splitInputNumbers = inputNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String splitInputNumber : splitInputNumbers) {
            numbers.add(Integer.parseInt(splitInputNumber.trim()));
        }
        return LottoNumber.from(numbers);
    }
}
