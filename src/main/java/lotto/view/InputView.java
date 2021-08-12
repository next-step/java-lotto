package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final int ZERO = 0;
    public static final int MINIMUM_LOTTO_MONEY = 1000;

    public int buyLottoView() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return checkMoney(scanner.nextLine());
    }

    public int checkMoney(String inputMoney) {
        int money = Integer.parseInt(inputMoney);

        if (money < ZERO) {
            throw new IllegalArgumentException("금액은 1000원 이상이어야 합니다.");
        }

        if (money % MINIMUM_LOTTO_MONEY != ZERO) {
            throw new IllegalArgumentException("금액은 1000원 단위어야 합니다.");
        }

        return money;
    }

}
