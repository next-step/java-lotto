package step3.view;

import java.util.Scanner;

public class InputView {
    static final String INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    static final String INPUT_LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    static Scanner sc = new Scanner(System.in);

    public int requestInput() {
        System.out.println(INPUT_MESSAGE);
        int charge = sc.nextInt();
        sc.nextLine();
        return charge;
    }

    public String requestWinningLottoNumber() {
        System.out.println(INPUT_LAST_LOTTO_NUMBER);
        String lastWinningLottoNum = sc.nextLine();
        return lastWinningLottoNum;
    }

    public Integer requestBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
