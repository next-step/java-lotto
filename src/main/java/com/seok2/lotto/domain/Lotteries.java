package com.seok2.lotto.domain;

import com.seok2.lotto.exception.MinimumLotteriesException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries implements Iterable<Lotto> {

    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        validate(lotteries);
        this.lotteries = lotteries;
    }

    public static Lotteries of(List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    private void validate(List<Lotto> lotteries) {
        if (lotteries.isEmpty()) {
            throw new MinimumLotteriesException();
        }
    }

    public Ranks check(WinningLotto winning) {
        return Ranks.of(lotteries.stream()
            .map(winning::check)
            .collect(Collectors.toList()));
    }

    public int size() {
        return lotteries.size();
    }

    public long sizeOfAuto() {
        return lotteries.stream()
            .filter(Lotto::isAuto)
            .count();
    }

    public long sizeOfManual() {
        return lotteries.stream()
            .filter(Lotto::isManual)
            .count();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lotteries.iterator();
    }
}
