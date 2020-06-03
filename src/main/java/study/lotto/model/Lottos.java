package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    public static Lottos of(int num) {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            lottoList.add(Lotto.auto());
        }

        return new Lottos(lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
