package lotto.auto.strategy;

import lotto.auto.model.LottoGame;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;
import static java.util.stream.IntStream.rangeClosed;

public final class AutoLotto implements LottoRule {
    private List<Integer> tickets;

    private AutoLotto() {
        this.tickets = new ArrayList<>();
        rangeClosed(1, 45).forEach(i -> tickets.add(i));
    }

    public static AutoLotto init() {
        return new AutoLotto();
    }

    @Override
    public LottoGame ticketing() {
        shuffle(tickets);
        ArrayList<Integer> tickets = new ArrayList<>(this.tickets.subList(0, 6));
        sort(tickets);
        return LottoGame.from(tickets);
    }
}
