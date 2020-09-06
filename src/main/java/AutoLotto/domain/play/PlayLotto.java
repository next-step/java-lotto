package AutoLotto.domain.play;

import AutoLotto.domain.lotto.Lotto;
import AutoLotto.domain.lotto.LottoNum;
import AutoLotto.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PlayLotto {

    private final Lottos lottos;
    private final List<LottoNum> buzzNumList;

    PlayLotto(Lottos lottos, List<LottoNum> buzzNumList) {
        this.lottos = lottos;
        this.buzzNumList = buzzNumList;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public List<LottoNum> getBuzzNumList() {
        return buzzNumList;
    }

    public void counts() {
        //LinkedHashMap<Integer, Integer>
        //Integer : hitNumber
        //Integer : counts of hitNumber
    }

    public List<Integer> countHits() {
        List<Integer> countHitsList = new ArrayList<>();
        for (Lotto lotto : getLottos()) {
            int countHit = buzzNumList.stream()
                    .mapToInt(buzzNum -> buzzNum.countMatch(lotto))
                    .sum();
            countHitsList.add(countHit);
        }
        return countHitsList;

    }

}