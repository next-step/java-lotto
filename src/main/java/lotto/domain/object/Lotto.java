package lotto.domain.object;

import lotto.domain.LottoGenerator;
import lotto.vo.LottoPrize;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;

    private final List<Integer> lotto;

    public Lotto() {
        lotto = new LottoGenerator().create();
    }

    public Lotto(final int[] lotto) {
        this.lotto = Arrays.stream(lotto).boxed().collect(Collectors.toList());
        Collections.sort(this.lotto);
    }

    public int getPrize(final int[] luckyNumbers) {
        final int count = countMatch(luckyNumbers);
        return LottoPrize.fromMatchCount(count).toMoney();
    }

    public int countMatch(final int[] luckyNumbers) {
        int countOfMatch = 0;
        for (int luckyNumber : luckyNumbers) {
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
}
