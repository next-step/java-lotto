package lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (구분: ',')");
        return scanner.next();
    }
}
