package AutoLotto.domain.play;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayLotto {

    private final Money budget;
    private final List<UserLotto> userLottos;
    private final List<LottoNumber> buzzLotto;

//    PlayLotto(int budget, BuzzLotto buzzLotto) {
      PlayLotto(int budget, List<UserLotto> userLottos, BuzzLotto buzzLotto) {
        this.budget = new Money(budget);
        //this.userLottos = UserLottos.buyLottosWith(budget);
        this.userLottos = userLottos;
        this.buzzLotto = buzzLotto.getBuzzLotto();
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

    public List<LottoNumber> getBuzzLotto() {
        return buzzLotto;
    }

    public boolean isPlayPlusProfit() {
        return budget.isPlusProfitBy(Rank.createBuzzMoney(countPlayMatch()));
    }

    public List<Integer> countPlayMatch() {
        return countMatchAll();
    }

    // 명령(count) - 질의(DTO, List<Integer> result) 구분 필요
    private List<Integer> countMatchAll() {
        List<Integer> matchCountList = new ArrayList<>( );
        for (UserLotto userLotto : userLottos) {
            int oneCount = countMatch(userLotto);
            matchCountList.add(oneCount);
        }
        return matchCountList;
    }

    private int countMatch(UserLotto userLotto) {
        int matchCount = getBuzzLotto().stream()
                .mapToInt(buzzNumber -> buzzNumber.countMatch(userLotto))
                .sum();
        return matchCount;
    }


    public Rank findRankByMatch(UserLotto userLotto) {
        int matchCount = countMatch(userLotto);
        return Rank.matchOf(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        PlayLotto playLotto = (PlayLotto) o;
        return Objects.equals(userLottos, playLotto.userLottos) &&
                Objects.equals(buzzLotto, playLotto.buzzLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottos, buzzLotto);
    }
}


// 어차피 hits 수를 구하는 것은 Rank 등수 구하기 위해서임. 반환값 Rank로 다시 하기
//    public List<Integer> countHits() {
//        List<Integer> countHitsList = new ArrayList<>();
//        for (UserLotto userLotto : getLottos()) {
//            int countHit = buzzNumList.stream()
//                    .mapToInt(buzzNum -> buzzNum.countMatch(userLotto))
//                    .sum();
//            countHitsList.add(countHit);
//        }
//        return countHitsList;
