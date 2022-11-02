package lotto;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> numbers) {
        lottos = new ArrayList<>();
        for (List<Integer> numberList : numbers) {
            lottos.add(Lotto.manual(numberList));
        }
    }

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(int n1, int n2, int n3, int n4, int n5, int n6) {
        lottos = new ArrayList<>();
        lottos.add(Lotto.manual(List.of(n1, n2, n3, n4, n5, n6)));
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void addAll(Lottos other) {
        this.lottos.addAll(other.lottos);
    }

    public Map<Winning, Integer> matching(WinningLotto winningLotto) {
        Map<Winning, Integer> winnings = new HashMap<>();
        for (Winning winning : Winning.values()) {
            winnings.put(winning, 0);
        }
        for (Lotto lotto : lottos) {
            Winning.of(lotto.matchCount(winningLotto.getLotto()),
                            lotto.doesLottoContainsLottoNumber(winningLotto.getBonusBall()) == 1)
                    .ifPresent(winning -> {
                        winnings.put(winning, winnings.get(winning) + 1);
                    });
        }
        return winnings;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }

}
