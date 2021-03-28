package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView(){
        this.scanner = new Scanner(System.in);
    }

    public Money buyLotto(){
        System.out.println("구매 금액을 입력해주세요.");
        return new Money(scanner.nextInt());
    }

    public WinningLotto winningLotto(){
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(scanner.nextLine());
    }
}
