package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;

    public LottoList(int count) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottoList.add(new Lotto());
        }
    }

    public LottoList(int count, List<Lotto> lottos) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottoList.add(lottos.get(i));
        }
    }
}
