package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NUMBER_SPLIT = ",";

    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return toNumber(scanner.nextLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(NUMBER_SPLIT))
                .map(this::toNumber)
                .toList();
    }

    private int toNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }
}
