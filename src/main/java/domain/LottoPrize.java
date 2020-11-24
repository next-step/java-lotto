package domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST_PRIZE( 6, 2_000_000_000 ),
    SECOND_PRIZE(5, 30_000_000 ),
    THIRD_PRIZE(5, 1_500_000 ),
    FOURTH_PRIZE(4, 50_000 ),
    FIFTH_PRIZE(3, 5_000 ),
    NOTHING(0, 0 );

    private final int matchingNumber;
    private final int prizeValue;
    private static final int SECOND_OR_THIRD = 5;

    LottoPrize(final int matchingNumber, final int prizeValue) {
        this.matchingNumber = matchingNumber;
        this.prizeValue = prizeValue;
    }

    public int getMatchingNumber() { return matchingNumber; }
    public int getPrizeValue() {
        return prizeValue;
    }

    public static LottoPrize of(int matchingNumber, boolean containsBonus){
        if(matchingNumber == SECOND_OR_THIRD) {
            return containsBonus ? SECOND_PRIZE : THIRD_PRIZE;
        }

        Optional<LottoPrize> optionalLottoPrize = Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getMatchingNumber() == matchingNumber)
                .findFirst();

        if(optionalLottoPrize.isPresent()) {
            return optionalLottoPrize.get();
        }

        return NOTHING;
    }
}
