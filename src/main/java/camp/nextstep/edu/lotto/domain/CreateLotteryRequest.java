package camp.nextstep.edu.lotto.domain;

import java.util.*;

public class CreateLotteryRequest {
    private final LotteryType lotteryType;
    private final List<Integer> numbers;

    private CreateLotteryRequest(LotteryType lotteryType, List<Integer> numbers) {
        if (lotteryType == null) {
            throw new IllegalArgumentException("'lotteryType' must not be null");
        }
        if (numbers == null) {
            throw new IllegalArgumentException("'numbers' must not be null");
        }
        this.lotteryType = lotteryType;
        this.numbers = new ArrayList<>(numbers);
    }

    public static CreateLotteryRequest random() {
        return new CreateLotteryRequest(LotteryType.RANDOM, Collections.emptyList());
    }

    public static CreateLotteryRequest custom(List<Integer> numbers) {
        return new CreateLotteryRequest(LotteryType.CUSTOM, numbers);
    }

    public boolean isRandom() {
        return lotteryType == LotteryType.RANDOM;
    }

    public boolean isCustom() {
        return lotteryType == LotteryType.CUSTOM;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
