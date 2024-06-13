package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoGame {

    private final LottoGamePolicy lottoGamePolicy;

    protected LottoGame(LottoGamePolicy lottoGamePolicy) {
        this.lottoGamePolicy = lottoGamePolicy;
    }

    public static LottoGame policyFrom(LottoGamePolicy lottoGamePolicy) {
        return new LottoGame(lottoGamePolicy);
    }

    public LottoGamePrize match(Lotto lotto, WinningLotto winningLotto) {
        return lottoGamePolicy.rank(
                lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count(),
                lotto.getNumbers().stream().anyMatch(winningLotto.getBonusNumber()::equals));
    }

    public float calculateRoi(HashMap<LottoGamePrize, Integer> result, int ticketCount) {
        int totalPrize = 0;

        for (LottoGamePrize prize : result.keySet()) {
            totalPrize += prize.getValue() * result.get(prize);
        }

        return Float.valueOf(totalPrize) / Float.valueOf(Lotto.PRICE * ticketCount);
    }

    public ArrayList<Lotto> generateLotto(int ticketCount) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }
}
