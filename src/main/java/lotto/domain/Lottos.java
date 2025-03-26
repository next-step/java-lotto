package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void determineAllLottoResult(List<LottoNumber> winningNumbers) {
        lottoList.forEach((lotto) -> lotto.determineLottoResult(winningNumbers));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }
}
