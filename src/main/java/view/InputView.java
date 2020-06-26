package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine(); // 이거 없으면 에러남, 왜 그럴까요?
        return scanner.nextLine();
    }
}
