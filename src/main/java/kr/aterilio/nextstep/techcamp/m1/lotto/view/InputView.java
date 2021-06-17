package kr.aterilio.nextstep.techcamp.m1.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MSG_GUIDE_INPUT_MONEY = "구입 금액을 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_LUCKY_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_COUNT_MANUAL = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MSG_GUIDE_INPUT_MANUAL = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }

    public int inputMoney() {
        System.out.println(MSG_GUIDE_INPUT_MONEY);
        int money = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return money;
    }

    public int inputCountManual() {
        System.out.println(MSG_GUIDE_INPUT_COUNT_MANUAL);
        int countManual = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return countManual;
    }

    public List<String> inputManual(int count) {
        System.out.println(MSG_GUIDE_INPUT_MANUAL);
        List<String> manual = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manual.add(scanner.nextLine());
        }
        System.out.println();
        return manual;
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
