package view;

import domain.Lotto;
import domain.Numbers;

import java.util.Scanner;

import static util.Constants.PRICE_OF_LOTTO;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        int result = Integer.parseInt(price);
        System.out.println(result / PRICE_OF_LOTTO + "개를 구매했습니다.");

        return result;
    }

    static Numbers getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winLotto = scanner.nextLine();

        return Numbers.of(winLotto.split(","));
    }
}
