package lotto.domain;

import java.util.*;

public class LottoNumbers implements Iterable<Integer> {
    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;

    private final List<Integer> lottoNumber;

    public LottoNumbers(List<Integer> lottoNumber) {
        this.lottoNumber = new ArrayList<>(lottoNumber);
        Collections.sort(this.lottoNumber);
    }

    private int contains(int number) {
        if (lottoNumber.contains(number)) {
            return MATCH_COUNT;
        }
        return NOT_MATCH_COUNT;
    }

    public int compare(LottoNumbers lottoNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : lottoNumbers) {
            matchCount += contains(winningNumber);
        }
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers integers = (LottoNumbers) o;
        return Objects.equals(lottoNumber, integers.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public Iterator<Integer> iterator() {
        return lottoNumber.iterator();
    }
}
