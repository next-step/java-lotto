package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    static final int SINGLE_LOTTO_AMOUNT = 1_000;

    private final int lottoCounts;

    public LottoFactory(int lottoAmounts) {
        this.lottoCounts = lottoAmounts / SINGLE_LOTTO_AMOUNT;
    }

    public List<Lotto> createLottos() {
        return IntStream.range(0, lottoCounts)
                .mapToObj(v -> new Lotto())
                .collect(Collectors.toList());
    }

    public int getLottoCounts() {
        return lottoCounts;
    }
}
