package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import lottoauto.model.request.LottoRequest;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }

    public static Lottos from(LottoRequest request) {
        List<Lotto> Lottos = new ArrayList<>(request.getManualLotteryNumbers());

        int autoQuantity = request.availableAutoLotteryCount();
        for (int i = 0; i < autoQuantity; i++) {
            Lottos.add(Lotto.auto());
        }

        return new Lottos(Lottos);
    }

}
