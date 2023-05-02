package lottery;

import java.util.List;
import java.util.Scanner;

public class LotteryStandConsoleView implements LotteryStandView {
    Scanner scanner = new Scanner(System.in);

    @Override
    public Integer getBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    @Override
    public void showBuyResult(List<Lottery> lotteries) {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
        for (var lottery : lotteries) {
            System.out.println(lottery.getNumbers());
        }
    }
}
