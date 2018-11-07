package raffle.lotto;

import java.util.List;

public class RandomLotto {

    private LottoList lottoList;

    public RandomLotto(int lottoAmount) {
        lottoList = new LottoList(lottoAmount);
    }

    public List<Lotto> getLottoList() {
        return lottoList.getLottos();
    }
}
