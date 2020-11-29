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

    public int size() {
        return this.lottos.size();
    }

    public void grid() {
        lottos.forEach(t -> System.out.println(t.toString()));
    }

    public Ranks ranks(Lotto lastWinningLotto) {
        Ranks ranks = new Ranks(new ArrayList<>());
        for (Lotto lotto : lottos) {
            ranks.add(lotto.match(lastWinningLotto));
        }
        return ranks;
    }

}
