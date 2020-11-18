package step2.view;

import java.util.Scanner;

public class LottoInputUi {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPurchaseAmount = scanner.nextInt();
        System.out.println(lottoPurchaseAmount);
        return lottoPurchaseAmount;
    }

    public String[] inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String lastWeekNumber = scanner.next();
        return lastWeekNumber.split(",");
    }

    public void close() {
        scanner.close();
    }

}
