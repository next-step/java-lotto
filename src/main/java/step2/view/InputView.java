package step2.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();

    }

    public String inputLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
