package edu.nextstep.step4.view;

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

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return Integer.parseInt(sc.nextLine());
    }

    public static void printExtractNumber(int purchasesNumber) {
        System.out.println(purchasesNumber + "개를 구매했습니다.");
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
