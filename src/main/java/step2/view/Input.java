package step2.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = scanner.nextInt();
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다.");
        return (purchaseAmount / 1000);

    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        scanner.nextLine();
        return Arrays.asList(scanner.nextLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
