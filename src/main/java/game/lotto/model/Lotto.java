package game.lotto.model;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final int NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;
    private final LottoType lottoType;

    private Lotto() {
        this.lottoType = LottoType.AUTO;
        this.lottoNumbers = LottoNumberFactory.createRandomLottoNumbers();
    }

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoType = LottoType.MANUAL;
        if(lottoNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호의 갯수는 6개입니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public static Lotto manual(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    public int getMatchOfCount(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream().filter(this::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isAuto() {
        return this.lottoType == LottoType.AUTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}
