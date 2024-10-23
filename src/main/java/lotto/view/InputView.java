package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER = "지난주 당첨번호를 입력해 주세요.";
    public static final String INPUT_BONUSBALL = "보너스 볼을 입력해 주세요.";
    public static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.print(INPUT_PRICE);
        int price = scanner.nextInt();
        scanner.nextLine(); // 남은 개행 문자 처리
        System.out.println("입력된 가격: " + price);
        return price;
    }

    public String inputAnswer() {
        System.out.print(INPUT_ANSWER);
        return scanner.nextLine();
    }

    public int inputBonus() {
        System.out.print(INPUT_BONUSBALL);
        return scanner.nextInt();

    }
}
