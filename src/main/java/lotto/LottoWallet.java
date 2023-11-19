package lotto;

import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public static LottoWallet from(List<Lotto> lottos) {
        return new LottoWallet(lottos);
    }

    public int remainTicketsCount() {
        return lottos.size();
    }

    public Lotto oneTicket(int index) {
        return lottos.get(index);
    }

}
