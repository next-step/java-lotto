package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String DELIMITER = ", ";

    public static int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinnerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumber = scanner.nextLine();

        String[] split = inputNumber.split(DELIMITER);

        return Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
