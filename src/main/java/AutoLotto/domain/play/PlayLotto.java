package AutoLotto.domain.play;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLottos;

import java.util.List;
import java.util.Objects;

public class PlayLotto {

    private final List<UserLotto> userLottos;
    private final List<LottoNumber> buzzLotto;

    PlayLotto(UserLottos userLottos, BuzzLotto buzzLotto) {
        this.userLottos = userLottos.getUserLottos();
        this.buzzLotto = buzzLotto.getBuzzLotto();
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

    public List<LottoNumber> getBuzzLotto() {
        return buzzLotto;
    }

    public void start() {
//        List<Integer> matchCountList = buzzLotto.countMatchAll(userLottos);
//        Rank.createBuzzMoney(buzzLotto.countMatchAll(userLottos));
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
