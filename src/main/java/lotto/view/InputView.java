package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount() {
        System.out.println("구입금액을 입력해 주세요.(1000원 단위)");

        int money = SCANNER.nextInt();
        int lottoCount = money / LOTTO_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }
}
