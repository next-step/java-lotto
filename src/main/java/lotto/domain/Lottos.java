package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> values;

    public Lottos(List<Lotto> lottos) {
        this.values = lottos;
    }

    public static Lottos from(int count) {
        List<Lotto> newLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            newLottos.add(Lotto.from(LottoNumbers.randomList()));
        }
        return new Lottos(newLottos);
    }

    public int size() {
        return values.size();
    }

    public LottoResult match(Lotto winningLotto) {
        List<LottoPrize> result = new ArrayList<>();
        for (Lotto lotto : values) {
            result.add(LottoPrize.from(winningLotto.matchCount(lotto)));
        }
        return new LottoResult(result);
    }

    public LottoResult match(WinningLotto winningLotto) {
        List<LottoPrize> result = new ArrayList<>();
        for (Lotto lotto : values) {
            result.add(LottoPrize.find(winningLotto.matchCount(lotto), winningLotto.matchBonus(lotto)));
        }
        return new LottoResult(result);
    }

    public String getLottoNumber(int index) {
        return values.get(index).toString();
    }
}
