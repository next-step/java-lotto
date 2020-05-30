package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;

    public LottoList() {
        lottoList = new ArrayList<>();
    }

    public static LottoList create(int num) {
        return new LottoList();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
