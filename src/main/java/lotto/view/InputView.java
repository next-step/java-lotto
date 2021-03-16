package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        scanner.nextLine();
        return Arrays.stream(scanner.nextLine().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
