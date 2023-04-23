package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Integer> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningNumber = SCANNER.next();
        String[] splitedNumber = winningNumber.split(",");

        return Arrays.stream(splitedNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
