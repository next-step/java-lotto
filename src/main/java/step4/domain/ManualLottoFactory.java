package step4.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManualLottoFactory {

    private final List<Lotto> lottos;

    public ManualLottoFactory(List<Lotto> lottoList) {
        lottos = lottoList;
    }

    public void addList(List<Lotto> lottoList) {
        lottoList.addAll(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottoFactory that = (ManualLottoFactory) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
