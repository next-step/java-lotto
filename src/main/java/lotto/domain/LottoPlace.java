package lotto.domain;

import java.util.Arrays;

public enum LottoPlace {

    NONE_PLACE(0, 0),
    FIFTH_PLACE(5000, 3),
    FOURTH_PLACE(50000, 4),
    THIRD_PLACE(1500000, 5),
    SECOND_PLACE(30000000, 5),
    FIRST_PLACE(2000000000, 6);

    private final int prize;
    private final int count;

    LottoPlace(int prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public static LottoPlace getLottoPlace(int count, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(lottoPlace -> lottoPlace.count == count)
            .map(lottoPlace -> checkBonus(lottoPlace, matchBonus))
            .findFirst().orElse(NONE_PLACE);
    }

    private static LottoPlace checkBonus(LottoPlace lottoPlace, boolean matchBonus) {
        if (lottoPlace.count == 5) {
            return rankWithMatchedBonus(matchBonus);
        }
        return lottoPlace;
    }

    private static LottoPlace rankWithMatchedBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }
}
