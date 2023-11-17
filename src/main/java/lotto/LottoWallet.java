package lotto;

import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoWallet from(int count) {
        LottoFactory lottoFactory = new LottoFactory();
        return new LottoWallet(lottoFactory.from(count));
    }

    public void saveLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int remainTicketsCount() {
        return lottos.size();
    }

    public Lotto oneTicket(int index) {
        return lottos.get(index);
    }

}
