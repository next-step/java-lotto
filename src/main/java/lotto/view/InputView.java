package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputTotalAmount() {
        System.out.println("구매 금액을 입력해주세요");
        int amount = sc.nextInt();
        sc.nextLine();
        return amount;
    }

    public static int inputManualQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int quantity = sc.nextInt();
        sc.nextLine();
        return quantity;
    }

    public static List<String> inputManualNumbers(int manualQuantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            manualNumbers.add(sc.nextLine());
        }
        return manualNumbers;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        sc.nextLine();
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return sc.nextInt();
    }
}
