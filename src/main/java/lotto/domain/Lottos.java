package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public static Lottos generateLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.generateLotto(LottoNumber.generateLottoNumber()));
        }
        return new Lottos(lottoList);
    }

}
