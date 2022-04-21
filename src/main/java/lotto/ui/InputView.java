package lotto.ui;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static int promptPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto promptWinningLotto() {
        System.out.println("지난 주 당첨 번호를 예시와 같은 형식으로 입력해 주세요. ex)1,2,3,4,5,6");
        String[] stringNumbers = scanner.nextLine()
                .trim()
                .split(",");
        List<Integer> numbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
