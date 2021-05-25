package lotto.domain.entity;

import lotto.domain.Lotto;
import lotto.domain.generator.AutomaticLottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto(new AutomaticLottoGenerator()));
        }
    }

    public LottoList(Lotto... lottoArrays) {
        lottoList.addAll(Arrays.asList(lottoArrays));
    }

    public int size() {
        return lottoList.size();
    }

    public Lotto get(int index) {
        return lottoList.get(index);
    }

    @Override
    public String toString() {
        return "LottoList = " + lottoList;
    }
}
