package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCenter {

    public static final int PRICE = 1000;

    public int buyLotto(int cash) {
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


    public List<Lotto> matchWinningNumber(List<Lotto> lottos, List<Integer> winningNumber) {
        for (Lotto lotto : lottos) {
            List<Integer> matchedList = lotto.selectedNumber().stream()
                    .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                    .collect(Collectors.toList());
            lotto.matchResult(matchedList.size());
        }
        return lottos;
    }
}
