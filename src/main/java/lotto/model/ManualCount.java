package lotto.model;


import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualCount {

    public static final String ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER = "수동으로 구매하고자 하는 로또의 갯수는 음수가 될 수 없습니다";
    public static final String ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT = "수동으로 구매하고자 하는 로또의 갯수가 구입금액보다 큽니다.";
    public static final int START_NUMBER = 0;
    private final int manualCount;
    private final BuyAmount buyAmount;

    public ManualCount(int manualCount, BuyAmount buyAmount) {
        boolean isMinus = manualCount < 0;
        if (isMinus) {
            throw new IllegalArgumentException(ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER);
        }

        boolean isManualCountBiggerThanBuyCount = buyAmount.count() < manualCount;
        if (isManualCountBiggerThanBuyCount) {
            throw new IllegalArgumentException(ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT);
        }

        this.manualCount = manualCount;
        this.buyAmount = buyAmount;
    }


    public int count() {
        return manualCount;
    }

    public List<Lotto> createLotto(IntFunction<Lotto> intFunction) {
        return IntStream.range(START_NUMBER, manualCount)
                .mapToObj(intFunction)
                .collect(Collectors.toList());
    }

    public int autoCount() {
        return buyAmount.count() - manualCount;
    }
}
