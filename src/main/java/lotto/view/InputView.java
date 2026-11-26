package lotto.view;

import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseNumber(scanner.nextLine());
    }

    public WinningLotto readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(parseNumbers(scanner.nextLine()));
    }

    static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : input.split(DELIMITER)) {
            numbers.add(parseNumber(token));
        }
        return numbers;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다: " + token, e);
        }
    }
}
