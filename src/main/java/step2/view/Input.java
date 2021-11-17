package step2.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    private static Integer purchaseAmount;

    public static Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = scanner.nextInt();
        this.purchaseAmount = purchaseAmount;
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다.");


    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        scanner.nextLine();
        return Arrays.asList(scanner.nextLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
