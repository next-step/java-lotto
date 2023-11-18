package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Match.*;

public class LottoCenter {

    public static final int PRICE = 1000;

    private final List<Long> result = new ArrayList<>();
    private static int cash;

    public List<Lotto> buyLotto(int cash) {
        LottoCenter.cash = cash;
        return generateTicket(cash);
    }

    private List<Lotto> generateTicket(int cash) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cash / PRICE; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public void matchWinningNumber(List<Lotto> lottos, Lotto winningNumbers) {
        for (Lotto lotto : lottos) {
            lotto.matchCount(winningNumbers);
        }
    }

    public List<Long> checkWinningResult(List<Lotto> lottos) {
        for (Match match : values()) {
            result.add(lottos.stream()
                    .filter(lotto -> Match.valueOf(lotto).equals(match)).count());
        }
        return result;
    }

    public float checkWinningRate() {
        return (float) ((result.get(0) * THREEMATCH.prize())
                + (result.get(1) * FOURMATCH.prize())
                + (result.get(2) * FIVEMATCH.prize())
                + (result.get(3) * SIXMATCH.prize())) / cash;
    }
}
