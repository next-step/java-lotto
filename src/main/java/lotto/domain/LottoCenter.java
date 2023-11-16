package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCenter {

    public static final int PRICE = 1000;
    private static final int THREEPRIZE = 5000;
    private static final int FOURPRIZE = 50000;
    private static final int FIVEPRIZE = 1500000;
    private static final int SIXPRIZE = 2000000000;

    private static int cash;
    private final List<Long> result = new ArrayList<>();

    public int buyLotto(int cash) {
        LottoCenter.cash = cash;
        return cash / PRICE;
    }

    public List<Lotto> generateTicket(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public void matchWinningNumber(List<Lotto> lottos, List<Integer> winningNumber) {
        for (Lotto lotto : lottos) {
            List<Integer> matchedList = lotto.selectedNumber().stream()
                    .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                    .collect(Collectors.toList());
            lotto.matchResult(matchedList.size());
        }
    }

    public List<Long> checkWinningResult(List<Lotto> lottos) {
        for (int i = 3; i <= 6; i++) {
            int winningMatch = i;
            long count = lottos.stream()
                    .filter(lotto -> lotto.getMatchCount() == winningMatch)
                    .count();
            this.result.add(count);
        }
        return result;
    }

    public float checkWinningRate() {
        return (float) ((result.get(0) * THREEPRIZE)
                + (result.get(1) * FOURPRIZE)
                + (result.get(2) * FIVEPRIZE)
                + (result.get(3) * SIXPRIZE)) / cash;
    }
}
