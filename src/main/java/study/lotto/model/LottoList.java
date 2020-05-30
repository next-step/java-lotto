package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList() {
        lottoList = new ArrayList<>();
    }

    public static LottoList create(int num) {
        LottoList lottoList = new LottoList();

        for(int i=0; i<num; i++) {
            lottoList.getLottoList().add(Lotto.generate());
        }

        return lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
