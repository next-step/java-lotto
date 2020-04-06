package lotto.domain;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final Set<Lotto> issuedLotto;

    public Lottos(int paidMoney) {
        issuedLotto = new HashSet<>();

        int count = paidMoney / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            issuedLotto.add(new Lotto());
        }
    }

    public Lottos(Set<Lotto> issuedLotto) {
        this.issuedLotto = Collections.unmodifiableSet(issuedLotto);
    }

    public int size() {
        return issuedLotto.size();
    }

    public Map<Winning, Integer> getResult(List<Integer> winningNumber) {
        Map<Winning, Integer> result = new HashMap<>();

        for (Lotto lotto : issuedLotto) {
            Winning winning = lotto.getResult(winningNumber);
            result.put(winning, result.containsKey(winning) ? result.get(winning) + 1 : 1);
        }

        return result;
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : issuedLotto) {
            stringBuilder.append(lotto.toString(format, delimiter));
        }

        return stringBuilder.toString();
    }
}
