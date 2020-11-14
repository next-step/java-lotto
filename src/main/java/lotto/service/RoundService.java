package lotto.service;

import lotto.domain.Pick;
import lotto.domain.Round;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RoundService {

    private final AutoPickService autoPickService;

    public RoundService(AutoPickService autoPickService) {
        this.autoPickService = autoPickService;
    }

    public Round buy(Set<Pick> myPicks) {
        Round round = new Round();
        round.addPicks(myPicks);
        return round;
    }

    public Round autoBuy(int count) {
        Set<Pick> picks = new HashSet<>();
        IntStream.range(0,count).forEach(i -> {
            picks.add(autoPickService.pick());
        });
        return buy(picks);
    }
}
