package lotto.domain;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final Set<Lotto> lottos;

    public Lottos(int paidMoney) {
        lottos = new HashSet<>();

        int count = paidMoney / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(Set<Lotto> lottos) {
        this.lottos = Collections.unmodifiableSet(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public Map<Winning, Integer> getResult(List<Integer> winningNumber) {
        Map<Winning, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            Winning winning = lotto.getResult(winningNumber);

            result.put(winning, getCountByWinningType(result, winning));
        }

        return result;
    }

    private int getCountByWinningType(Map<Winning, Integer> result, Winning winning) {
        if (result.containsKey(winning)) {
            return result.get(winning) + 1;
        }

        return 1;
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString(format, delimiter));
        }

        return stringBuilder.toString();
    }
}
