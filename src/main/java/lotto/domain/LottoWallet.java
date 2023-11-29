package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;


    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoWallet of(List<Lotto> lottos) {
        return new LottoWallet(lottos);
    }

    public int totalTicketCount() {
        return lottos.size();
    }

    public Lotto oneTicket(int index) {
        return lottos.get(index);
    }

    public int manuallyLottoCount() {
        return (int) lottos.stream().filter(lotto -> lotto.lottoType().equals(LottoType.MANUALLY))
            .count();
    }

    public int autoLottoCount() {
        return (int) lottos.stream().filter(lotto -> lotto.lottoType().equals(LottoType.AUTO))
            .count();
    }

}
