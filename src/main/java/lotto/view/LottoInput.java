package lotto.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoInput {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final int LIMIT_AMOUNT = 100000;
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
        Matcher matcher = NUMBER_PATTERN.matcher(amount);
        if(!matcher.find()) {
            throw new IllegalArgumentException("구매금액은 숫자만 입력이 가능합니다.");
        }

        int purchasedAmount = Integer.parseInt(amount);

        if(purchasedAmount <= 0) {
            throw new IllegalArgumentException("구매금액은 0보다 커야 합니다.");
        }

        if(purchasedAmount >= LIMIT_AMOUNT) {
            throw new IllegalArgumentException("구매금액은 " + LIMIT_AMOUNT + "를 초과할 수 없습니다.");
        }

        return purchasedAmount;
    }
}
