package lotto.domain;

import java.util.List;

public class Game {
    private final List<Lotto> lottoList;

    public Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoSize() {
        return lottoList.size();
    }
}
