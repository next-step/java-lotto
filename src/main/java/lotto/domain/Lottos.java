package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public static Lottos of(int paidMoney, LottoGeneratorStrategy lottoGeneratorStrategy) {
        int count = paidMoney / LOTTO_PRICE;
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto(lottoGeneratorStrategy))
                        .limit(count)
                        .collect(Collectors.toList()));
    }

    public Map<Long, Long> getWinningCount(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.findSameNumber(winningNumbers))
                .filter(count -> count >= WINNING_STANDARD_NUMBER)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
