package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();

    public List<Lotto> from(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLottoTicket());
        }
        return lottos;
    }

    private Lotto createLottoTicket() {
        return Lotto.from(lottoNumberFactory.number());
    }

}
