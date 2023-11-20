package lotto.domain;

import lotto.domain.strategy.NumberGeneration;

import java.util.*;

public class Lotto {
    public static final int SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(NumberGeneration numberGeneration) {
        this.lotto = validate(numberGeneration.generate());
    }

    private List<LottoNumber> validate(List<LottoNumber> list) {
        if (list.size() == SIZE) {
            return list;
        }
        throw new InputMismatchException("로또 번호는 6자리를 입력해 주세요.");
    }

    public List<LottoNumber> find() {
        return Collections.unmodifiableList(lotto);
    }

    public LottoRank findRank(Lotto winLotto, LottoNumber bonus) {
        if (isRank(winLotto)) {
            return LottoRank.findMatchCount(countMath(winLotto), contains(bonus));
        }
        return LottoRank.MISS;

    }

    public boolean contains(LottoNumber bonus) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonus));
    }

    public int countMath(Lotto winLotto) {
        List<LottoNumber> matchResult = new ArrayList<>(lotto);
        matchResult.retainAll(winLotto.find());
        return matchResult.size();
    }

    private boolean isRank(Lotto winLotto) {
        return countMath(winLotto) > 2;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
