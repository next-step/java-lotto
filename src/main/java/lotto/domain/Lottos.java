package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    public static final int LOTTO_PRICE = 1000;
    public static final int WINNING_STANDARD_NUMBER = 3;
    public static final int LOTTO_MAX_SIZE = 6;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int paidMoney) {
        int count = paidMoney / LOTTO_PRICE;
        return new Lottos(
                Stream.generate(Lotto::createLotto)
                        .limit(count)
                        .collect(Collectors.toList()));
    }

    public Map<Integer, Long> getWinningCount(String[] winningNumbers) {
        Map<Integer, Long> winningCount = new HashMap<>();
        for (int i = WINNING_STANDARD_NUMBER; i <= LOTTO_MAX_SIZE; i++) {
            winningCount.put(i, (long) 0);
        }

        lottos.stream()
                .mapToLong(lotto -> lotto.findSameNumber(winningNumbers))
                .filter(count -> count >= WINNING_STANDARD_NUMBER)
                .forEach(count -> {
                    Long temp = winningCount.get(count) + 1;
                    winningCount.replace((int) count, temp);
                });

        return winningCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
