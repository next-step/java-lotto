package domain;

import java.util.Map;

public class LottoGame {

    public static final int TICKET_PRICE = 1_000;

    private final Lottos lottos;

    public LottoGame(){
        this.lottos = new Lottos();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoGame buy(int ticketCount){
        lottos.buy(ticketCount);
        return this;
    }

    public Map<PrizeEnum, Integer> calculateWinResult(LottoNumbers winNumbers, int bonus){
        return lottos.calculateWinResult(winNumbers, bonus);
    }
}
