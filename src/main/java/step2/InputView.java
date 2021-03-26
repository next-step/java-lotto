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

}
