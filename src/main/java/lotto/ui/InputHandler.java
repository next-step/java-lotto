package lotto.ui;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private InputHandler(){
        this.scanner = new Scanner(System.in);
    }
    public static InputHandler of(){
        return new InputHandler();
    }

    public int inputMoney(){
        System.out.println("구입 금액을 입력해주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public String inputWinnerNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }


    public void closeScanner() {
        scanner.close();
    }
}
