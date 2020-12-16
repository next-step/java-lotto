package step4.domain;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void checkWinningLotto(LottoNumber number, LottoNumber bonus) {
        lottos.stream()
                .forEach(lottoNumber -> lottoNumber.checkLottoMatchCount(number,bonus));
    }

    public LottoResult winningLottoResult() {
        return new LottoResult(lottos.stream()
                .collect(groupingBy(Lotto::getCount)));
    }

    public List<Lotto> getLottoNumber() {
        return lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lottos that = (Lottos) o;

        return lottos != null ? lottos.equals(that.lottos) : that.lottos == null;
    }

    @Override
    public int hashCode() {
        return lottos != null ? lottos.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
