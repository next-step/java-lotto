package step4.View;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int passivePurchase() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public void passiveLottoNumberPrint() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String passiveLottoNumber() {
        return scanner.next();
    }

    public String inputLastInteger() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public int inputBonus() {
        System.out.println("보너스 번호 입력해주세요.");
        return scanner.nextInt();
    }


}
