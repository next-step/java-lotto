package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<String> inputLastWeeksNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return Arrays.asList(scanner.nextLine().split(", "));
    }
}
