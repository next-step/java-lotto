package autolotto;

import java.util.Scanner;

public class LottoInput {
    private static final Scanner scanner = new Scanner(System.in);

    public int askQuantity(String question) {
        System.out.println(question);

        int purchaseAmount = scanner.nextInt();
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return purchaseAmount;
    }

    public String askWinningNumber(String question) {
        System.out.println(question);
        return scanner.next();
    }
}
