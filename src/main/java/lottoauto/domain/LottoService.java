package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;
import lottoauto.model.Lotto;
import lottoauto.model.Lottos;

public class LottoService {

    public Lottos generateLottoNumber(int quantity) {
        return new Lottos(generateLotto(quantity));
    }

    private List<Lotto> generateLotto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotto.add(new Lotto());
        }
        return lotto;
    }

}
