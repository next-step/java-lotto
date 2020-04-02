package lotto.domain;

import java.util.*;

public class IssuedLotto {
    private final Set<Lotto> issuedLotto;

    public IssuedLotto(int count) {
        issuedLotto = new HashSet<>();

        for (int i = 0; i < count; i++) {
            issuedLotto.add(new Lotto(NumberGenerator.generateOneSet()));
        }
    }

    public IssuedLotto(Set<Lotto> issuedLotto) {
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
