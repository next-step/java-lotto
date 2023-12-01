package step2;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String cal = scanner.nextLine();
        return stringToInteger(cal);
    }

    public String inputWinningNumber(){
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNum = scanner.nextLine();
        return winningNum;
    }

    private int stringToInteger(String text){
        text = text.trim();
        if (text.isEmpty() && text.isBlank()){
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        return Integer.parseInt(text);
    }
}
