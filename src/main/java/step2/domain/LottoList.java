package step2.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 묶음
 */
public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(int count) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
