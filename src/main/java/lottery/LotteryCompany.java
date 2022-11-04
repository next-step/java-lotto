package lottery;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryCompany {

    static final int LOTTERY_PRICE = 1000;

    private static final List<LotteryNumber> LOTTERY_NUMBER_CANDIDATES = IntStream
            .rangeClosed(1, LotteryNumber.LOTTERY_NUM_MAX)
            .mapToObj(LotteryNumber::new)
            .collect(Collectors.toList());

    public static Lottery randomLottery() {
        Collections.shuffle(LOTTERY_NUMBER_CANDIDATES);
        return new Lottery(LOTTERY_NUMBER_CANDIDATES.subList(0, Lottery.LOTTERY_NUM_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public static int availablePurchaseAmount(int totalPurchasePrice) {
        int availablePurchaseAmount = totalPurchasePrice / LOTTERY_PRICE;
        if (availablePurchaseAmount <= 0) {
            throw new IllegalArgumentException("입력한 구입 금액으로 로또를 구입할 수 없습니다.");
        }
        return availablePurchaseAmount;
    }

}
