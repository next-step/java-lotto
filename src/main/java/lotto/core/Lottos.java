package lotto.core;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoSize) {
        while (lottos.size() < lottoSize) {
            lottos.add(new Lotto(new LottoCommonGenerateStrategy()));
        }
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosAmount(){
        return lottos.size();
    }
}
