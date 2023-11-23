package step4.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import step4.domain.Lottery;
import step4.util.LotteryUtil;

public class InputView {

    public static final int UNIT_OF_PRICE = 1000;
    private static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_LAST_WEEK_LOTTERY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BUNUS_LOTTERY_NUMBERS = "보너스 볼을 입력해 주세요.";
    private static final String ASK_TICKETS_OF_MANUAL_LOTTERY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_NUMBER_OF_MANUAL_LOTTERY_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getAllTicketCount(int money) {
        return money / UNIT_OF_PRICE;
    }

    public static int getMoney() {
        System.out.println(ASK_MONEY);
        String moneyStr = SCANNER.nextLine();

        return parse(moneyStr);
    }

    public static int getManualTicketCount() {
        System.out.println(ASK_TICKETS_OF_MANUAL_LOTTERY);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<List<Integer>> getManualNumbers(int manualTicketCount) {
        System.out.println(ASK_NUMBER_OF_MANUAL_LOTTERY_NUMBERS);

        List<List<Integer>> manualTickets = new ArrayList<>();
        for (int count = 0; count < manualTicketCount; count++) {
            List<Integer> numbers = LotteryUtil.getNumbers(SCANNER.nextLine());
            isDuplicated(numbers);

            manualTickets.add(numbers);
        }

        return manualTickets;
    }

    public static void showTicketCount(int manualTicketCount, int autoTicketCount) {
        System.out.println("수동으로 " + manualTicketCount +
                           "장, 자동으로" + autoTicketCount + "개를 구매했습니다.");
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

    private static void isDuplicated(List<Integer> numbers) {
        Set<Integer> collect = numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1)
                                      .collect(Collectors.toSet());

        if (!collect.isEmpty()) {
            throw new IllegalArgumentException("중복된 숫자를 넣을 수 없어요.");
        }
    }
}
