package autolotto.view;

import java.util.Scanner;

public class LottoInput {
    public static final String AMOUNT_QUESTION = "구입 금액을 입력해주세요. ex. 14000";
    public static final String WINNGING_NUMBER_QUESTION = "지난주 당첨 번호를 콤마(,)를 기준으로 입력해주세요. ex. 1,2,3,4,5,6";
    private static final Scanner scanner = new Scanner(System.in);

    public int askAmount(String question) {
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
