package step3.view;

import step3.domain.LottoNumber;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE);
        return sc.nextInt();
    }

    public static String inputWinNumber() {
        System.out.println();
        System.out.println(WIN_NUMBER);

        sc.nextLine();
        return sc.nextLine();
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return LottoNumber.of(sc.nextInt());
    }
}
