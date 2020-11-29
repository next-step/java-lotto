package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos lotto(Money money) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < money.getChances(); i++) {
            list.add(LottoGenerator.generate());
        }
        return new Lottos(list);
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Ranks ranks(Lotto lastWinningLotto, LottoNumber bonusNumber) {
        Ranks ranks = new Ranks(new ArrayList<>());
        for (Lotto lotto : lottos) {
            ranks.add(lotto.match(lastWinningLotto, bonusNumber));
        }
        return ranks;
    }

}
