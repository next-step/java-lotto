package step2.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int receiveInputNumber() {
        System.out.println("구입 금액을 구입해주세요.");
        int value = scanner.nextInt();
        scanner.nextLine();

        System.out.println(value + "개를 구매했습니다.");
        return value;
    }

    public String receiveInputString() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return scanner.nextLine();
    }
}
