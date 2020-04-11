package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {
    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries of(List<List<Integer>> requestManualLottoNumbers) {
        return new Lotteries(requestManualLottoNumbers.stream()
                .map(Lotto::of)
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

}
