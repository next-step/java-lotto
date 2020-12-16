package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public Lottos(int lottoCount) {
        this();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            this.addLotto(lotto);
        }
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    /**
     * 로또 목록의 크기를 반환합니다.
     * @return
     */
    public int size() {
        return this.lottos.size();
    }
}
