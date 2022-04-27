package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinnerType {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    NON_WIN(-1, false, 0);

    private int countOfDuplicate;
    private boolean isBonus;
    private int prize;

    LottoWinnerType(int countOfDuplicate, boolean isBonus, int prize) {
        this.countOfDuplicate = countOfDuplicate;
        this.isBonus = isBonus;
        this.prize = prize;
    }

    private static final Map<String, LottoWinnerType> cache;

    static {
        cache = new HashMap<>();
        for (LottoWinnerType e : LottoWinnerType.values()) {
            cache.put(createCacheKey(e.countOfDuplicate, e.isBonus), e);
        }
    }

    public static int prize(int countOfDuplicate, boolean isBonus) {
        try {
            String key = createCacheKey(countOfDuplicate, isBonus);
            return cache.get(key).prize;
        } catch (NullPointerException e) {
            return NON_WIN.prize;
        }
    }

    public static int prize(LottoWinnerType winnerType) {
        return winnerType.prize;
    }

    public static LottoWinnerType valueOf(int countOfDuplicate, boolean isBonus) {
        String key = createCacheKey(countOfDuplicate, isBonus);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return NON_WIN;
    }

    private static String createCacheKey(int countOfDuplicate, boolean isBonus) {
        String bonusYn = isBonus == true ? "Y" : "N";
        String key = countOfDuplicate + bonusYn;

        return key;
    }

    public static boolean isMatchingCountWithBonus(int countOfDuplicate) {
        if (countOfDuplicate != SECOND_PLACE.countOfDuplicate) {
            return false;
        }
        return true;
    }

    public int getCountOfDuplicate() {
        return countOfDuplicate;
    }

    public int getPrize() {
        return prize;
    }
}
