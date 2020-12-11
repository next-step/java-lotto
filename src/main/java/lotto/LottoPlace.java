package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<LottoPlace> getWinnerPlaces() {
        return Arrays.stream(values())
                .filter(lottoPlace -> lottoPlace.place > 0)
                .sorted(Comparator.comparingInt(lottoPlace -> lottoPlace.place))
                .collect(Collectors.toList());
    }

    public static LottoPlace findByNumMatchedOrNone(int numMatched) {
        return Arrays.stream(values())
                .filter(lottoPlace -> lottoPlace.getNumMatched() == numMatched)
                .findFirst()
                .orElse(LottoPlace.MATCHED_NONE);
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
