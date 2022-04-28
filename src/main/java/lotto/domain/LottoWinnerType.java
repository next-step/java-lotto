package lotto.domain;

import lotto.exception.InvalidLottoWinnerTypeException;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinnerType {
    FIRST_PLACE(Identifier.FIRST_KEY, 2_000_000_000),
    SECOND_PLACE(Identifier.SECOND_KEY, 30_000_000),
    THIRD_PLACE(Identifier.THIRD_KEY, 1_500_000),
    FOURTH_PLACE(Identifier.FOURTH_KEY, 50_000),
    FIFTH_PLACE(Identifier.FIFTH_KEY, 5_000),
    NON_WIN(Identifier.NON_WIN_KEY, 0);

    private Identifier key;
    private int prize;

    LottoWinnerType(Identifier key, int prize) {
        this.key = key;
        this.prize = prize;
    }

    private static final Map<Identifier, LottoWinnerType> CACHE;

    static {
        CACHE = new HashMap<>();
        for (LottoWinnerType e : LottoWinnerType.values()) {
            CACHE.put(e.key, e);
        }
    }

    public static int prize(int countOfDuplicate, boolean isBonus) {
        try {
            Identifier key = Identifier.getMatchedIdentifierInstance(countOfDuplicate, isBonus);
            return CACHE.get(key).prize;
        } catch (NullPointerException e) {
            return NON_WIN.prize;
        }
    }

    public static int prize(LottoWinnerType winnerType) {
        return winnerType.prize;
    }

    public static LottoWinnerType valueOf(int countOfDuplicate, boolean isBonus) {
        Identifier key = Identifier.getMatchedIdentifierInstance(countOfDuplicate, isBonus);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }
        return NON_WIN;
    }

    static boolean matchCountWithBonus(int countOfDuplicate) {
        if (countOfDuplicate != SECOND_PLACE.key.getCountOfDuplicate()) {
            return false;
        }
        return true;
    }

    public int getCountOfDuplicate() {
        return key.getCountOfDuplicate();
    }

    public int getPrize() {
        return prize;
    }
}

enum Identifier {
    FIRST_KEY(6, false),
    SECOND_KEY(5, true),
    THIRD_KEY(5, false),
    FOURTH_KEY(4, false),
    FIFTH_KEY(3, false),
    NON_WIN_KEY(-1, false);

    private int countOfDuplicate;
    private boolean isBonus;

    Identifier(int countOfDuplicate, boolean isBonus) {
        this.countOfDuplicate = countOfDuplicate;
        this.isBonus = isBonus;
    }

    static Identifier getMatchedIdentifierInstance(int countOfDuplicate, boolean isBonus) {
        if (countOfDuplicate < FIFTH_KEY.countOfDuplicate) {
            return NON_WIN_KEY;
        }

        if (countOfDuplicate != SECOND_KEY.countOfDuplicate) {
            return getMatchedIdentifierInstanceWithoutBounus(countOfDuplicate);
        }

        return getMatchedIdentifierInstanceWithBounus(isBonus);

    }

    private static Identifier getMatchedIdentifierInstanceWithoutBounus(int countOfDuplicate) {
        if (countOfDuplicate == FIRST_KEY.countOfDuplicate) {
            return FIRST_KEY;
        }

        if (countOfDuplicate == FOURTH_KEY.countOfDuplicate) {
            return FOURTH_KEY;
        }

        if (countOfDuplicate == FIFTH_KEY.countOfDuplicate) {
            return FIFTH_KEY;
        }

        throw new InvalidLottoWinnerTypeException();
    }

    private static Identifier getMatchedIdentifierInstanceWithBounus(boolean isBonus) {
        return isBonus == true ? SECOND_KEY : THIRD_KEY;
    }

    int getCountOfDuplicate() {
        return countOfDuplicate;
    }
}
