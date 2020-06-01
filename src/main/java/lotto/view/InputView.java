package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final int ONE_SALE_PRICE = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        int lottoCount = money / ONE_SALE_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }
}
