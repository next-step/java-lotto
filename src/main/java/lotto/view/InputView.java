package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
        //int money = scanner.nextInt();
        //int lottoCount = new Money(money).countLotto();

        //System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public String[] inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(",");
    }
}
