package AutoLotto.domain.play;

import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLottos;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {

    private final UserLottos userLottos;
    private final List<LottoNumber> buzzNumList;

    PlayLotto(UserLottos userLottos, List<LottoNumber> buzzNumList) {
        this.userLottos = userLottos;
        this.buzzNumList = buzzNumList;
    }

    public List<UserLotto> getLottos() {
        return userLottos.getLottos();
    }

    public List<LottoNumber> getBuzzNumList() {
        return buzzNumList;
    }

    public void counts() {
        //LinkedHashMap<Integer, Integer>
        //Integer : hitNumber
        //Integer : counts of hitNumber
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

}

