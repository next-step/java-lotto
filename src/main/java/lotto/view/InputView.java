package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int getLottoTicketPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = scanner.nextInt();
        validateLottoTicketPurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public static String[] getLastWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(", ");
    }

    private static void validateLottoTicketPurchaseAmount(int lottoTicketPurchaseAmount) {
        if (lottoTicketPurchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상이어야 합니다.");
        }
    }

}
