package AutoLotto.domain.lotto;

import AutoLotto.domain.play.Rank;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 명령(count) - 질의(DTO, List<Integer> result) 구분 필요
    public List<Integer> countMatchAll(List<UserLotto> userLottos) {
        List<Integer> matchCountList = new ArrayList<>( );
        for (UserLotto userLotto : userLottos) {
            int oneCount = countMatch(userLotto);
            matchCountList.add(oneCount);
        }
        return matchCountList;
    }

    public Rank findRankByMatch(UserLotto userLotto) {
        int matchCount = countMatch(userLotto);
        return Rank.matchOf(matchCount);
    }

    private int countMatch(UserLotto userLotto) {
        int matchCount = getBuzzLotto().stream()
                .mapToInt(buzzNumber -> buzzNumber.countMatch(userLotto))
                .sum();
        return matchCount;
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

