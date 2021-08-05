package step2.view;

import java.util.Scanner;

public class InputView {
    static final String INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    static final String INPUT_INFO_MESSAGE = "개를 구매했습니다.";
    static final String INPUT_LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final int chargeOfLotto = 1000;
    static Scanner sc = new Scanner(System.in);

    public int requestInput() {
        System.out.println(INPUT_MESSAGE);
        int charge = sc.nextInt();
        sc.nextLine();
        int numOfLotto = charge/chargeOfLotto;
        System.out.println(numOfLotto+INPUT_INFO_MESSAGE);
        return numOfLotto;
    }

    public String requestLottoNumber() {
        System.out.println(INPUT_LAST_LOTTO_NUMBER);
        String lastLottoNum = sc.nextLine();
        return lastLottoNum;
    }
}
