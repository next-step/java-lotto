package step3.domain.model.Lotto;


import step3.domain.strategy.lotto.LottoPolicyStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.from(new LottoPolicyStrategy()));
        }
    }
    public Lottos(List<Lotto> lottos) {
       this.lottos = lottos;
    }

    public static Lottos fromManualLottos(List<List<Integer>> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottos.size(); i++) {
            lottos.add(Lotto.fromManualLotto(new LottoPolicyStrategy(), manualLottos.get(i)));
        }
        return new Lottos(lottos);
    }

    public static Lottos from(int lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("음수의 갯수는 잘못된 값입니다.");
        }
        return new Lottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void combineLottos(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }
}
