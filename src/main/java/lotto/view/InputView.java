package lotto.view;

import lotto.domain.MyNumber;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.domain.LottoMachine.*;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String INPUT_RETRY = " 다시 입력해주세요.";
    public static final String INPUT_MIN_PRICE_MESSAGE = "금액은 최소 " + LOTTO_PRICE + "원 이상 입력이 가능합니다.";
    public static final String INPUT_CORRECT_PRICE_UNIT_MESSAGE = "금액은 " + LOTTO_PRICE + "원 단위로 입력이 가능합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public int lottoCount(String message) {
        System.out.println(message);

        try {
            int money = scanNextInt();
            int countOfLotto = money / LOTTO_PRICE;
            System.out.println(countOfLotto + "개를 구매했습니다.");
            return countOfLotto;
        } catch (NumberFormatException e) {
            return lottoCount(INPUT_NUMBER_MESSAGE + INPUT_RETRY);
        } catch (IllegalArgumentException e) {
            return lottoCount(e.getMessage());
        }
    }

    private int scanNextInt() {
        int nextInt = Integer.parseInt(scanner.nextLine());

        if (isInputLowerThanPrice(nextInt)) {
            throw new IllegalArgumentException(INPUT_MIN_PRICE_MESSAGE + INPUT_RETRY);
        }

        if (isInputPriceUnitWrong(nextInt)) {
            throw new IllegalArgumentException(INPUT_CORRECT_PRICE_UNIT_MESSAGE + INPUT_RETRY);
        }

        return nextInt;
    }

    public LottoNumber winnnigNumbersInput(String message) {
        System.out.println(message);
        String inputNumbers = scanner.nextLine();
        String[] splitInputNumbers = inputNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String splitInputNumber : splitInputNumbers) {
            numbers.add(Integer.parseInt(splitInputNumber.trim()));
        }

        try {
            return LottoNumber.from(numbers);
        } catch (IllegalArgumentException e) {
            return winnnigNumbersInput(e.getMessage() + INPUT_RETRY);
        }
    }

    public MyNumber getBonusNumber(String message, LottoNumber winningNumber) {
        System.out.println(message);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        try {
            return MyNumber.bonusNumberFrom(inputNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            return getBonusNumber(e.getMessage() + INPUT_RETRY, winningNumber);
        }
    }
}
