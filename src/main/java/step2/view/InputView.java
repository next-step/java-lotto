package step2.view;

import java.util.Scanner;

public class InputView {
    static final String INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    static final String INPUT_INFO_MESSAGE = "개를 구매했습니다.";
    private static final int chargeOfLotto = 1000;
    static Scanner sc = new Scanner(System.in);

    public int requestInput() {
        System.out.println(INPUT_MESSAGE);
        int charge = sc.nextInt();
        int numOfLotto = charge/chargeOfLotto;
        System.out.println(numOfLotto+INPUT_INFO_MESSAGE);
        return numOfLotto;
    }
}
