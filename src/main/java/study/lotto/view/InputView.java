package study.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;
import static java.lang.System.out;

public class InputView {

    private static final Scanner scanner = new Scanner(in);
    private static final String ASKING_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASKING_LAST_WEEK_ANSWER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ASKING_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final int PRICE_PER_SHEET = 1000;


    public static Integer inputMoney() {
        out.println(ASKING_MONEY);
        int money = scanner.nextInt();
        out.println(money/ PRICE_PER_SHEET + "개를 구매했습니다.");
        return money;
    }

    public static List<Integer> inputLastWeekAnswer() {
        out.println(ASKING_LAST_WEEK_ANSWER);
        String next = scanner.next();
        return Arrays.stream(next.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        out.println(ASKING_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
