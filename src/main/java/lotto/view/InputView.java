package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ", ";
    private static Scanner scanner = new Scanner(System.in);

    public int inputBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public int[] inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        scanner.nextLine();
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
