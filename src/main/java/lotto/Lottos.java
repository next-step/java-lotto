package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int count, LottoBallPolicy lottoBallPolicy) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoBallPolicy.shuffleLottoNumber();
            lottoList.add(createLottoByPolicy(lottoBallPolicy));
        }
    }

    public Lotto createLottoByPolicy(LottoBallPolicy lottoBallPolicy) {
        return Lotto.createLotto(lottoBallPolicy.getLottoNumber(Lotto.getMaxSize()));
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int getLottoListSize(){
        return lottoList.size();
    }
}
