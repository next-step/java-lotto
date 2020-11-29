package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-27 오후 1:11
 * Developer : Seo
 */
public class LottoGame {

    public static Lottos lotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getChances(); i++) {
            lottos.add(LottoNumber.generate());
        }
        return new Lottos(lottos);
    }

    private LottoGame() {
    }
}
