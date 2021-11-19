package step2.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static Scanner SCANNER = new Scanner(System.in);

    private static Integer PRICE_PER_LOTTO = 1000;

    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = SCANNER.nextInt();
        System.out.println(purchaseAmount / PRICE_PER_LOTTO + "개를 구매했습니다.");
        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        SCANNER.nextLine();
        return Arrays.asList(SCANNER.nextLine().split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
