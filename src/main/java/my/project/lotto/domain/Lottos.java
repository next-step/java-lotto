package my.project.lotto.domain;

import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public void grid() {
         lottos.forEach(t -> System.out.println(t.toString()));
    }

    public int match(Lotto lastWinningLotto) {
        int count = 0;
        for (Lotto lotto : lottos) {
            count += lotto.match(lastWinningLotto);
        }
        return count;
    }

}
