package step4.view;

import java.util.List;
import java.util.Scanner;

import step4.domain.Lottery;

public class InputView {

    public static final int UNIT_OF_PRICE = 1000;
    private static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE = "개를 구매했습니다.";
    private static final String ASK_LAST_WEEK_LOTTERY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BUNUS_LOTTERY_NUMBERS = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getTicketCount(int money) {
        return money / UNIT_OF_PRICE;
    }

    public static int start() {
        System.out.println(ASK_MONEY);
        String moneyStr = SCANNER.nextLine();

        return parse(moneyStr);
    }

    public static void showTicketCount(int ticketCount) {
        System.out.println(ticketCount + PURCHASE);
    }

    public static void showLotteries(List<Lottery> tickets) {
        tickets.forEach(t -> System.out.println(t.getNumbers()));
    }

    public static String getWinNumber() {
        System.out.println(ASK_LAST_WEEK_LOTTERY_NUMBERS);
        return SCANNER.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(ASK_BUNUS_LOTTERY_NUMBERS);
        return SCANNER.nextLine();
    }

    public static int parse(String moneyStr) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyStr);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 금액을 입력해주세요.");
        }

        isValidPrice(money);

        return money;
    }

    private static void isValidPrice(int money) {
        if (money < UNIT_OF_PRICE) {
            throw new IllegalArgumentException("1000원 이상 넣어주세요. 투입 금액 - " + money);
        }

        if ((money % UNIT_OF_PRICE) > 0) {
            throw new IllegalArgumentException("천원 단위로 넣어주세요 투입 금액 - " + money);
        }
    }
}
