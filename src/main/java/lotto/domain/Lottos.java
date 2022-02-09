package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final int START_NUMBER = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void makeManualLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public void makeAutoLottos(int lottoCount) {
        for (int i = START_NUMBER; i < lottoCount; ++i) {
            Lotto lotto = new Lotto();

            lottos.add(lotto.getLottoTicket());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
