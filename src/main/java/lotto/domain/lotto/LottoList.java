package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoList {

    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int size() {
        return lottoList.size();
    }

    public LottoList addAll(LottoList lottoList) {
        List<Lotto> lottos = this.lottoList.stream().collect(Collectors.toList());
        lottos.addAll(lottoList.lottoList.stream().collect(Collectors.toList()));
        return new LottoList(lottos);
    }

    public List<Lotto> lottoList() {
        return Collections.unmodifiableList(this.lottoList);
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

    public List<String> toStringList() {
        return lottoList.stream().map(lotto -> lotto.toString()).collect(Collectors.toList());
    }
}
