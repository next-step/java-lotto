package lottery.view;

import lottery.Lottery;
import lottery.LotteryNumber;
import lottery.WinningLottery;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getTotalPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualLotteryAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Lottery> getManualLotteries(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteries.add(new Lottery(getLotteryNumbers()));
        }
        return Collections.unmodifiableList(lotteries);
    }

    public static WinningLottery getWinningLottery() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLottery(getLotteryNumbers(), getBonusNumber());
    }

    public static List<LotteryNumber> getLotteryNumbers() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LotteryNumber::lotteryNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private static LotteryNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LotteryNumber.lotteryNumber(scanner.nextInt());
    }
}
