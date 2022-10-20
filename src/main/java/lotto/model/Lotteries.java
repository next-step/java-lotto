package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotteries {

    private final List<Lotto> lotteries;
    private final List<Lotto> manualLotteries;

    public Lotteries(List<Lotto> lotteries, List<Lotto> manualLotteries) {
        this.lotteries = lotteries;
        this.manualLotteries = manualLotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getLottoCount() {
        return this.lotteries.size();
    }

    public int getManualLottoCount() {
        return this.manualLotteries.size();
    }

    public List<Lotto> getAllLotteries() {
        return Stream.concat(lotteries.stream(), manualLotteries.stream())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}
