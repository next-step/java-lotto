package step2.view;

import java.util.Scanner;
import step2.domain.Lotto;
import step2.domain.Lottos;

public class PurchaseView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int PRICE_OF_LOTTO = 1000;

    private PurchaseView() {

    }

    public static int getPurchasedValue() {
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseUnsignedInt(SCANNER.next());
    }

    public static int getNumberOfLottos(int purchasedValue) {
        int numberOfLottos = purchasedValue / PRICE_OF_LOTTO;
        System.out.println(numberOfLottos + " 개를 구매했습니다.");
        return numberOfLottos;
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
