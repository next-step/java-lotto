package kr.aterilio.nextstep.techcamp.m1.lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String MSG_GUIDE_INPUT_MONEY = "구입 금액을 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_LUCKY_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }

    public int inputMoney() {
        System.out.println(MSG_GUIDE_INPUT_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputLuckyNumber() {
        System.out.println(MSG_GUIDE_INPUT_LUCKY_NUMBER);
        return scanner.nextLine();
    }

    public int inputBonusBall() {
        System.out.println(MSG_GUIDE_INPUT_BONUS_BALL);
        return Integer.parseInt(scanner.nextLine());
    }
}
