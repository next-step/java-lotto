package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBucket {

    private final List<Lotto> lottos;

    public LottoBucket() {
        this.lottos = new ArrayList<>();
    }

    public void createLotto(Lotto lotto) {
        lotto.createLotto();
        addLotto(lotto);
    }

    protected void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
