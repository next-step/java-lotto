package lotto.ui;

import lotto.domian.Lotto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static int questionOrder() {
        System.out.println("구입금액을 입력해 주세요.");
        int answer = Integer.parseInt(scanner.nextLine());
        System.out.println(answer / Lotto.PURCHASE_UNIT + "개를 구매했습니다.");
        return answer;
    }

    public static String questionWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String questionBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}
