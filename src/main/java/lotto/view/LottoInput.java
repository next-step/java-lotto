package lotto.view;

import java.util.Scanner;

public class LottoInput {

    private static Scanner scanner = new Scanner(System.in);

    public int getPurchasedAmount() {
        System.out.println("구매금액을 입력하세요.");
        String amount = scanner.nextLine();
        return purchaseValid(amount);
    }

    public String getWinningNumbers() {
        System.out.println("지난 주 당첨번호를 입력하세요.");
        return scanner.nextLine();
    }

    public int purchaseValid(String amount) {

        if(amount.isBlank()) {
            throw new IllegalArgumentException("구매금액이 없을수는 없습니다.");
        }

        int purchasedAmount = parseAmount(amount);
        validateAmountPositive(purchasedAmount);

        return purchasedAmount;
    }

    private int parseAmount(String amount) {
        try {
          return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 유효한 숫자여야 합니다.", e);
        }
    }

    private void validateAmountPositive(int purchasedAmount) {
        if (purchasedAmount <= 0) {
            throw new IllegalArgumentException("구매금액은 0보다 커야 합니다.");
        }
    }

}
