package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;
    private Lotto lotto;

    public Lottos(Price price) {
        this.lottoList = generateLottos(price.lottoCount());
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> generateLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            generateLotto.add(new Lotto());
        }
        return generateLotto;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
