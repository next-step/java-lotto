package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count, LottoGenerator lottoGenerator){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++){
            lottos.add(new Lotto(lottoGenerator.randomNumber()));
        }

        this.lottos = lottos;
    }

    public List<Lotto> lottos() { return lottos; }

}
