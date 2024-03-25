package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {
    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;
    private static final int SIZE = 6;

    private final List<LottoNumber> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        if (new HashSet<>(lottoNumber).size() != SIZE) {
            throw new IllegalArgumentException("로또는 중복되지 않은 6개의 숫자여야 합니다.");
        }

        this.lottoNumber = lottoNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.sort(this.lottoNumber);
    }

    private int contains(LottoNumber number) {
        if (lottoNumber.contains(number)) {
            return MATCH_COUNT;
        }
        return NOT_MATCH_COUNT;
    }

    public int compare(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber winningNumber : lotto) {
            matchCount += contains(winningNumber);
        }
        return matchCount;
    }

    public boolean containBonusNumber(LottoNumber bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto integers = (Lotto) o;
        return Objects.equals(lottoNumber, integers.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumber.iterator();
    }
}
