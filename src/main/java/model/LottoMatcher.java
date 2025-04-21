package model;

import java.util.HashSet;
import java.util.Set;

public class LottoMatcher {
    private static final int MIN_REQUIRED_MATCH_COUNT = 3;

    private LottoMatcher () {}

    public static int count(Lotto lotto1, Lotto lotto2) {
        Set<Integer> copy = new HashSet<>(lotto1.numbers());
        copy.retainAll(lotto2.numbers());
        int matchCount = copy.size();
        return matchCount < MIN_REQUIRED_MATCH_COUNT ? 0 : matchCount;
    }

    public static LottoMatch match(Lotto lotto1, Lotto lotto2, int bonusNumber) {
        Set<Integer> copy = new HashSet<>(lotto1.numbers());
        copy.retainAll(lotto2.numbers());
        int matchCount = copy.size();
        boolean bonusNumberMatch = lotto1.contains(bonusNumber);
        return new LottoMatch(matchCount, bonusNumberMatch);
    }
}
