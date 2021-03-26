package step2.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public final class LottoList {

    private final List<Lotto> lottoList;

    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public final static LottoList newInstance(List<Lotto> lottoList) {
        return new LottoList(lottoList);
    }

    public final static LottoList newInstance() {
        return new LottoList(new ArrayList<>());
    }

    public final void add(Lotto additionalLotto) {
        lottoList.contains(additionalLotto);
    }

}
