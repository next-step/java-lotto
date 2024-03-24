package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class LottoNumbers implements Iterable<Integer> {
    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;

    private final List<Integer> lottoNumber;

    public LottoNumbers(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int contains(int number) {
        if (lottoNumber.contains(number)) {
            return MATCH_COUNT;
        }
        return NOT_MATCH_COUNT;
    }

    @Override
    public Iterator<Integer> iterator() {
        return lottoNumber.iterator();
    }

    @Override
    public String toString() {
        return this.lottoNumber.toString();
    }
}
