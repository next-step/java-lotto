package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static LottoTicket buy(Money money) {
        long count = money.countAvailable(Lotto.getPrice());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return LottoTicket.of(lottos);
    }

    public static WinningLotto getWinningLotto(WinningLottoRequest winningLottoRequest) {
        Lotto lotto = LottoGenerator.generate(winningLottoRequest.getNumbers());
        return WinningLotto.generate(lotto, winningLottoRequest.getBonus());
    }
}
