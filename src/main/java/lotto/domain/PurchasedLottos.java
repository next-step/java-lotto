package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    public PurchasedLottos() {
        lottos = new ArrayList<>();
    }

    public PurchasedLottos(Integer... numbers) {
        this(List.of(new Lotto(numbers)));
    }

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto buyLotto : lottos) {
            lottoResult.putLottoResult(winningLotto.matchCount(buyLotto));
        }

        return lottoResult;
    }

    public void add(Lotto lotto){
        this.lottos.add(lotto);
    }

    public void addAll(PurchasedLottos lottos){
        this.lottos.addAll(lottos.lottos);
    }

    public String toLottosString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "PurchasedLottos{" +
                "lotto=" + lottos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedLottos buyLotto = (PurchasedLottos) o;
        return Objects.equals(getLottos(), buyLotto.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLottos());
    }


}
