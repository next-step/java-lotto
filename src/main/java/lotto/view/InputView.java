package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String STR1 = "구입금액을 입력해 주세요.";
    public static final String STR2 = "지난주 당첨번호를 입력해 주세요.";
    public static final String STR3 = "보너스 볼을 입력해 주세요.";
    public static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.print(STR1);
        int price = scanner.nextInt();
        scanner.nextLine(); // 남은 개행 문자 처리
        System.out.println("입력된 가격: " + price);
        return price;
    }

    public String inputAnswer() {
        System.out.print(STR2);
        return scanner.nextLine();
    }

    public int inputBonus() {
        System.out.print(STR3);
        return scanner.nextInt();

    }
}
