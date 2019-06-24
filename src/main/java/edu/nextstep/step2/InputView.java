package edu.nextstep.step2;

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

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        Money money = new Money(sc.nextInt());

        checkExtractNumber(money);
        return money;
    }

    public static void checkExtractNumber(Money money) {
        System.out.println(money.getNumberOfExtract() + "개를 구매했습니다.");
    }

}
