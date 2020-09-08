package AutoLotto.domain.lotto;

import AutoLotto.domain.play.Rank;

import java.util.List;
import java.util.Objects;

public class BuzzLotto {

    private final List<LottoNumber> buzzLotto;

    public BuzzLotto(List<LottoNumber> buzzLotto) {
        this.buzzLotto = buzzLotto; //이건 생성하는 것이 아니라 getter할 값으로 팩토리 불필요
    }

    public List<LottoNumber> getBuzzLotto() {
        return buzzLotto;
    }

    public int countMatch(List<LottoNumber> userLotto) {
        return userLotto
                .stream( ).filter(lottoNumber -> buzzLotto.contains(lottoNumber))
                .mapToInt(i -> 1)
                .sum();
    }

    public Rank findRankByMatch(List<LottoNumber> userLotto) {
        int matchCount = countMatch(userLotto);
        return Rank.matchOf(matchCount);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        BuzzLotto buzzLotto1 = (BuzzLotto) o;
        return Objects.equals(buzzLotto, buzzLotto1.buzzLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buzzLotto);
    }
}

