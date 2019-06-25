package edu.nextstep.step2.view;

import edu.nextstep.step2.domain.LotteryNumber;
import edu.nextstep.step2.domain.Money;
import edu.nextstep.step2.domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static Scanner sc = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        Money money = new Money(Integer.parseInt(sc.nextLine()));

        checkExtractNumber(money);
        System.out.println();
        return money;
    }

    public static void checkExtractNumber(Money money) {
        System.out.println(money.getNumberOfExtract() + "개를 구매했습니다.");
    }

    public static LotteryNumber inputLotteryNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lottery = sc.nextLine();

        return new LotteryNumber(splitLotteryNumber(lottery));

    }

    private static List<Number> splitLotteryNumber(String lottery) {

        return Arrays.stream(lottery.replaceAll(SPACE, "").split(COMMA))
                .filter(splitString -> !"".equals(splitString))
                .map(Integer::parseInt)
                .map(number -> new Number(number))
                .collect(Collectors.toList());
    }

}
