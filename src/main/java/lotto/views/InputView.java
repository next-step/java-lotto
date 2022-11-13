package lotto.views;

import java.util.Scanner;

import lotto.LottoWinningStats;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = SCANNER.nextInt();
        SCANNER.nextLine();

        validateInputAmount(purchaseAmount);
        System.out.println((purchaseAmount / LottoWinningStats.PRICE) + "개를 구매했습니다.");
        return purchaseAmount;
    }

    private static void validateInputAmount(int purchaseAmount) {
        if(purchaseAmount < LottoWinningStats.PRICE) {
            throw new IllegalArgumentException("로또 최소 구입 금액보다 작습니다.");
        }
    }

    public static String inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
