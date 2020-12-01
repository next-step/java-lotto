package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoPlace {

    MATCHED_NONE(0, 0, 0),
    MATCHED_3(5, 3, 5000),
    MATCHED_4(4, 4, 50000),
    MATCHED_5(3, 5, 1500000),
    MATCHED_6(1, 6, 2000000000);

    private final int place;
    private final int numMatched;
    private final int prize;

    LottoPlace(int place, int numMatched, int prize) {
        this.place = place;
        this.numMatched = numMatched;
        this.prize = prize;
    }

    public static LottoPlace[] getWinnerPlaces() {
        return Arrays.stream(values())
                .filter(lottoPlace -> lottoPlace.place > 0)
                .sorted(Comparator.comparingInt(lottoPlace -> lottoPlace.place))
                .toArray(LottoPlace[]::new);
    }

    public int getNumMatched() {
        return numMatched;
    }

    public int getPrize() {
        return prize;
    }

    public int getPlace() {
        return place;
    }

}
