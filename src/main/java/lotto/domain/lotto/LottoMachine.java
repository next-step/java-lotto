package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> lottoTicket;

    private LottoMachine() {}

    public static LottoMachine create(){
        return new LottoMachine();
    }

    public List<Lotto> purchaseLotto(int quantity) {
        lottoTicket = createLotto(quantity);
        return lottoTicket;
    }

    private List<Lotto> createLotto(int quantity) {
        lottoTicket = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTicket.add(Lotto.create());
        }
        return lottoTicket;
    }


}
