package com.seok2.lotto.domain;

import static java.util.stream.Collectors.toList;

import com.seok2.lotto.exception.EmptyLotteriesException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lotteries implements Iterable<Lotto>{

    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        validate(lotteries);
        this.lotteries = Collections.unmodifiableList(lotteries);
    }

    private void validate(List<Lotto> lotteries) {
        if (lotteries == null || lotteries.isEmpty()) {
            throw new EmptyLotteriesException();
        }
    }

    public Ranks check(WinningLotto winning) {
        return Ranks.of(lotteries.stream()
            .map(winning::check)
            .collect(toList()));
    }

    public long sizeOfAuto() {
        return lotteries.stream()
            .filter(Lotto::isAuto)
            .count();
    }

    public long sizeOfManual() {
        return lotteries.size() - sizeOfAuto();
    }

    static Lotteries of(List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lotteries.iterator();
    }
}
