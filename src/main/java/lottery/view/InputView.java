package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구매금액을 입력해 주세요");

        final int result = sc.nextInt();
        sc.nextLine();

        return result;
    }

    public static void viewTicketCount(int count) {
        System.out.println(count + "개를 구입했습니다.");
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");

        final String[] result = sc.nextLine()
                .replaceAll(" ", "")
                .split(",");

        System.out.println();

        return Arrays.stream(result)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
