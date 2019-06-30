package edu.nextstep.step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 01:11
 */
public class InputView {

    private static Scanner sc = new Scanner(System.in);
    private static final String EXTRACT_MESSAGE_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());

    }

    public static List<String> inputManualNumber(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();

        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(sc.nextLine());
        }
        return manualLottos;
    }

    public static void printExtractNumber(int manualCount, int purchasesNumber) {
        System.out.println(String.format(EXTRACT_MESSAGE_FORMAT, manualCount, purchasesNumber));
    }

    public static String inputLotteryNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
