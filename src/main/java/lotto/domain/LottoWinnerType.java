package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinnerType {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    NON_WIN(-1, 0);

    private int countOfDuplicate;
    private int prize;

    LottoWinnerType(int countOfDuplicate, int prize) {
        this.countOfDuplicate = countOfDuplicate;
        this.prize = prize;
    }

    private static final Map<Integer, LottoWinnerType> mapToPrize;

    static {
        mapToPrize = new HashMap<>();
        for (LottoWinnerType e : LottoWinnerType.values()) {
            mapToPrize.put(e.countOfDuplicate, e);
        }
    }

    public static int prize(int countOfDuplicate) {
        try {
            return mapToPrize.get(countOfDuplicate).prize;
        } catch (NullPointerException e) {
            return NON_WIN.prize;
        }
    }

    public static LottoWinnerType valueOf(int countOfDuplicate) {
        if (mapToPrize.containsKey(countOfDuplicate)) {
            return mapToPrize.get(countOfDuplicate);
        }

        return NON_WIN;
    }

    public int getCountOfDuplicate() {
        return countOfDuplicate;
    }
}
