package lotto.domain;

import java.util.List;

public class Game {
    private final List<Lotto> lottoList;
    private Lotto PreviousLotto;

    public Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void setPreviousLotto(Lotto previousLotto) {
        this.PreviousLotto = previousLotto;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoSize() {
        return lottoList.size();
    }
}
