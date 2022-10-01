package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int askPurchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        int purchaseAmount = SCANNER.nextInt();
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0){
            throw new IllegalArgumentException("0보다 큰 수만 입력할 수 있습니다.");
        }
    }

    public static String[] askWinnerNumbers() {

        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String nextLine = SCANNER.next();
            return nextLine.split(",");
        }catch (Exception e){
            System.out.println(e.getMessage());
            askWinnerNumbers();
        }
        return new String[]{};
    }
}
