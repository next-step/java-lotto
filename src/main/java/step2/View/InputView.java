package step2.View;

import step2.Domain.*;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Money buyLotto() {
        System.out.println("구매 금액을 입력해주세요.");
        return new Money(scanner.nextInt());
    }

    public WinningLotto winningLotto() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(new Lotto(new InputNumber(scanner.nextLine())),bonusBall());
    }

    private LottoNumber bonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        return new LottoNumber(scanner.nextInt());
    }
}
