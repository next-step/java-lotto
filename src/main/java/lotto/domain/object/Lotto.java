package lotto.domain.object;

import aterilio.common.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;

    private static final String TO_STRING_TOKEN = ", ";

    private final List<Integer> lotto;

    public Lotto(final int[] lotto) {
        this(Arrays.stream(lotto).boxed().collect(Collectors.toList()));
    }

    public Lotto(final List<Integer> lotto) {
        this.lotto = lotto;
        Collections.sort(this.lotto);
    }

    public int countMatch(final Lotto luckyNumbers) {
        int countOfMatch = 0;
        for (int luckyNumber : luckyNumbers.lotto) {
            countOfMatch += judgeMatchAndCount(luckyNumber);
        }
        return countOfMatch;
    }

    private int judgeMatchAndCount(final int luckyNumber) {
        return lotto.contains(luckyNumber) ? MATCH_COUNT : NOT_MATCH_COUNT;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof Lotto ) {
            final Lotto that = (Lotto) obj;
            return Objects.equals(this.lotto, that.lotto);
        }
        if ( obj instanceof int[] ) {
            final int[] array = (int[]) obj;
            return Objects.equals(
                    this.lotto
                    , Arrays.stream(array)
                            .boxed()
                            .collect(Collectors.toList())
            );
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "[" + StringUtils.serialize(lotto.toArray(), TO_STRING_TOKEN) + "]";
    }
}
