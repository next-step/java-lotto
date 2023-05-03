package lotto.view;

import lotto.domain.LottoRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String SPLIT_DELIMITER = ", ";
    private static final String REGEX = "\\d+";

    public static int buy() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = new Scanner(System.in).nextInt();
        System.out.println(money / LottoRule.PRICE + "개를 구매했습니다.");
        return money;
    }

    public static List<Integer> inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = new Scanner(System.in).nextLine();
        return makeNumbers(input);
    }

    public static List<Integer> makeNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] strNumbers = input.split(SPLIT_DELIMITER);
        for (String strNumber : strNumbers) {
            validateNumber(strNumber);
            numbers.add(Integer.valueOf(strNumber));
        }
        return numbers;
    }

    private static void validateNumber(String strNumber) {
        if (!strNumber.matches(REGEX)) {
            throw new IllegalArgumentException("숫자로만 구성되어 있지 않은 값이 있습니다.");
        }
        if (!LottoRule.NUMBER_RANGE.contains(Integer.valueOf(strNumber))) {
            throw new IllegalArgumentException("입력된 숫자 범위가 올바르지 않습니다.");
        }
    }
}
