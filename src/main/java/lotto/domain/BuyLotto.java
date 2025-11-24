package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuyLotto {

    private final List<Lotto> lottos;

    public BuyLotto() {
        lottos = new ArrayList<>();
    }

    public BuyLotto(Integer... numbers) {
        this(List.of(new Lotto(numbers)));
    }

    public BuyLotto(List<Lotto> lottos) {
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

    @Override
    public String toString() {
        return "BuyLotto{" +
                "lotto=" + lottos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BuyLotto buyLotto = (BuyLotto) o;
        return Objects.equals(getLottos(), buyLotto.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLottos());
    }


}
