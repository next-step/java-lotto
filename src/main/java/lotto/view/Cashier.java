package lotto.view;

import lotto.model.LotteryTicket;
import lotto.model.LotteryTickets;

import java.util.List;
import java.util.Scanner;

public class Cashier {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static void sayLotteryCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showLotteryTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets().forEach(lotteryTicket -> System.out.println(lotteryTicket));
        System.out.println();
    }
}
