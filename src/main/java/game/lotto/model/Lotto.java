package game.lotto.model;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final int NUMBER_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumberFactory.createRandomLottoNumbers();
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {

        if(lottoNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호의 갯수는 6개입니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    public Rank getMatchRank(Lotto lotto) {
        int countOfMatch = getMatchOfCount(lotto);
        return Rank.valueOf(countOfMatch);
    }

    int getMatchOfCount(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream().filter(this::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }
}
