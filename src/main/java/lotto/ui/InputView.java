package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int questionOrder() {
        System.out.println("구입금액을 입력해 주세요.");
        int answer = Integer.parseInt(scanner.nextLine());
        System.out.println(answer / 1000 + "개를 구매했습니다.");
        return answer;
    }
}
