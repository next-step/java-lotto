package lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseCount() {
        System.out.println("구입금액을 입력해 주세요");
        int amount = Integer.parseInt(scanner.nextLine());
        int count = amount / Lottery.price;
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    public static Integer[] getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return convert(input.split(","));
    }


    private static Integer[] convert(String[] tokens) {
        return Arrays.stream(tokens)
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList())
            .toArray(new Integer[6]);
    }

}
