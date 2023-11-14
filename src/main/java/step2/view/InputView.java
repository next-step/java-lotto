package step2.view;

import java.util.List;
import java.util.Scanner;

import step2.model.Lottery;
import step2.model.Winning;

public class InputView {

    private static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE = "개를 구매했습니다.";
    private static final String ASK_LAST_WEEK_LOTTERY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int start() {
        System.out.println(ASK_MONEY);
        String moneyStr = SCANNER.nextLine();
        int money = parse(moneyStr);

        return getTrialCount(money);
    }

    public static int getTrialCount(int money) {
        int ticketCount = money / 1000;
        System.out.println(ticketCount + PURCHASE);
        return ticketCount;
    }

    public static void showActorLotteries(List<Lottery> tickets) {
        tickets.forEach(t -> System.out.println(t.getNumbers()));
    }

    public static Winning getWinning() {
        System.out.println(ASK_LAST_WEEK_LOTTERY_NUMBERS);
        String numberStr = SCANNER.nextLine();

        return Winning.from(numberStr);
    }

    public static int parse(String moneyStr) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyStr);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 금액을 입력_해_주세요.");
        }

        if (money < 1000) {
            throw new IllegalArgumentException("1000원 이상 넣어_주세요. 입력 - " + money);
        }

        return money;
    }
}
