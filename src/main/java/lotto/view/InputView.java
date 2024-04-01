package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ", ";

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public List<Integer> lastWeekLottoNumber() {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine()
                        .split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
