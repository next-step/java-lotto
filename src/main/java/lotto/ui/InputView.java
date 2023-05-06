package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int PURCHASE_UNIT = 1000;

    public static int questionOrder() {
        System.out.println("구입금액을 입력해 주세요.");
        int answer = Integer.parseInt(scanner.nextLine());
        System.out.println(answer / PURCHASE_UNIT + "개를 구매했습니다.");
        return answer;
    }

    public static String questionWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
