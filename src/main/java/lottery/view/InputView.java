package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_DELIMITER = ", ";
    private static Scanner scanner = new Scanner(System.in);

    public static int payAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        return purchaseAmount;
    }

    public static List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        String[] winNumbers = checkInput(input);
        return Arrays.stream(winNumbers)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    private static String[] checkInput(String input) {
        String[] numbers = input.split(INPUT_DELIMITER);
        if (numbers.length != 6) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.");
        }
        return numbers;
    }

}
