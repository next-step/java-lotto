package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;

    private InputView() {
    }

    public static int buyLotto() {
        System.out.println("구매 금앱을 입력해 주세요.");
        int count = Integer.parseInt(scanner.nextLine()) / LOTTO_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static String inputWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
