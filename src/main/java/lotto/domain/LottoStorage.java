package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {

    private final List<Lotto> lottoList;

    public LottoStorage(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> copy() {
        List<Lotto> result = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            result.add(Lotto.from(lotto));
        }
        return result;
    }
}
