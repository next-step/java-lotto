package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {
    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;
    private static final int SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> lotto) {
        if (new HashSet<>(lotto).size() != SIZE) {
            throw new IllegalArgumentException("로또는 중복되지 않은 6개의 숫자여야 합니다.");
        }

        this.lotto = lotto.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.sort(this.lotto);
    }

    private int checkMatchCount(LottoNumber number) {
        if (lotto.contains(number)) {
            return MATCH_COUNT;
        }
        return NOT_MATCH_COUNT;
    }

    public int compare(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber winningNumber : lotto) {
            matchCount += checkMatchCount(winningNumber);
        }
        return matchCount;
    }

    public Rank getRank(Lotto winningLotto, LottoNumber bonusNumber) {
        int matchCount = compareLottoNumbers(winningLotto);
        boolean matchBonus = containBonusNumber(winningLotto, bonusNumber);
        return Rank.findRank(matchCount, matchBonus);
    }

    private boolean containBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        return winningLotto.contains(bonusNumber);
    }

    private boolean contains(LottoNumber bonusNumber) {
        return this.lotto.contains(bonusNumber);
    }

    private int compareLottoNumbers(Lotto winningLotto) {
        return compare(winningLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto integers = (Lotto) o;
        return Objects.equals(lotto, integers.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lotto.iterator();
    }
}
