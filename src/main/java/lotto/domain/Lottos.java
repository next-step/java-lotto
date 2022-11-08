package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<LottoTicket> lottos;

    public Lottos(List<LottoTicket> lottos) {
        this.lottos = lottos;
    }

    public static Lottos lottosMake(int lottoCount){
        List<LottoTicket> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(LottoTicket.lottoMake());
        }
        return new Lottos(lottos);
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }
}
