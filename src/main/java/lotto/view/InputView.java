package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public BigDecimal readMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return BigDecimal.valueOf(scanner.nextLong());
    }

    public List<Integer> readWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String input = scanner.nextLine().replaceAll(" ", "");
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
