package camp.nextstep.edu.lotto.domain;

import java.util.stream.Collectors;

public final class LotteryFactory {
    private LotteryFactory() {
    }

    public static Lottery create(CreateLotteryRequest createLotteryRequest) {
        if (createLotteryRequest.isCustom()) {
            return Lottery.customizedInstance(createLotteryRequest.getNumbers()
                    .stream()
                    .map(LotteryNumber::from)
                    .collect(Collectors.toSet()));
        }
        if (createLotteryRequest.isRandom()) {
            return Lottery.randomizedInstance();
        }
        throw new IllegalArgumentException("'lotteryType' is not supported");
    }
}
