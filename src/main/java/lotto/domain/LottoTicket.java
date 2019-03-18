package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
    private int lottosCount;
    private List<Lotto> lottos;

    public LottoTicket(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException();
        }

        this.lottosCount = lottosCount;
        this.lottos = new ArrayList<>(this.lottosCount);
    }

    public List<Lotto> publish() {
        for (int i = 0; i < this.lottosCount; i++) {
            this.lottos.add(new Lotto());
        }

        return this.lottos;
    }

    public Map<Integer, List<Lotto>> announceWinningResult(final List<Integer> winningNumbers) {
        Map<Integer, List<Lotto>> winningResults = new HashMap<>();

        List<Lotto> lottosHasThreeWinning = new ArrayList<>();
        List<Lotto> lottosHasFourWinning = new ArrayList<>();
        List<Lotto> lottosHasFiveWinning = new ArrayList<>();
        List<Lotto> lottosHasSixWinning = new ArrayList<>();

        this.lottos.forEach(lotto -> {
            if (lotto.getContainsCount(winningNumbers) == 3) {
                lottosHasThreeWinning.add(lotto);
            }

            if (lotto.getContainsCount(winningNumbers) == 4) {
                lottosHasFourWinning.add(lotto);
            }

            if (lotto.getContainsCount(winningNumbers) == 5) {
                lottosHasFiveWinning.add(lotto);
            }

            if (lotto.getContainsCount(winningNumbers) == 6) {
                lottosHasSixWinning.add(lotto);
            }
        });

        winningResults.put(3, lottosHasThreeWinning);
        winningResults.put(4, lottosHasFourWinning);
        winningResults.put(5, lottosHasFiveWinning);
        winningResults.put(6, lottosHasSixWinning);

        return winningResults;
    }

    public int getLottosCount() {
        return lottosCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
