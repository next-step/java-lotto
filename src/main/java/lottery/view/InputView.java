package lottery.view;

import lottery.LotteryNumber;
import lottery.WinningLottery;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getLotteryPurchasePrices() {
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static WinningLottery getWinningLottery() {
        return new WinningLottery(getWinningLotteryNumbers(), getBonusLotteryNumber());
    }

    private static List<LotteryNumber> getWinningLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private static LotteryNumber getBonusLotteryNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LotteryNumber(scanner.nextInt());
    }
}
