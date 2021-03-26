package step2.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        lottoList.add(additionalLotto);
    }

    public final List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoList lottoList1 = (LottoList) o;
        return Objects.equals(lottoList, lottoList1.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
