package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    public static final String NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPrice() {
        System.out.println("구매금액을 입력해 주세요.");
        int price = scanner.nextInt();

        scanner.nextLine();

        return price;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();

        return Arrays.stream(value.split(NUMBER_DELIMITER))
                .map(Integer::new)
                .collect(toList());
    }
}
