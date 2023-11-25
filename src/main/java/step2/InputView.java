package step2;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String cal = scanner.nextLine();
        return cal;
    }

    public String inputWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNum = scanner.nextLine();
        return winningNum;
    }
}
