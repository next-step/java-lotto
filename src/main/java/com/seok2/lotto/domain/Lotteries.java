package com.seok2.lotto.domain;

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
            throw new IllegalArgumentException("최소 한 장 이상의 게임을 구매해야 합니다.");
        }
    }

    public Ranks check(Lotto winning) {
        return Ranks.of(lotteries.stream()
            .map(winning::check)
            .collect(Collectors.toList()));
    }

    public int size() {
        return lotteries.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lotteries.iterator();
    }
}
