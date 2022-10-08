package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if(lottos ==null){
            throw new IllegalArgumentException("로또가 생성되지 않았습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
