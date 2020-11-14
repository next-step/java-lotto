package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.Round;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RoundService {

    private final AutoPickService autoPickService;
    private final LottoService lottoService;

    public RoundService(AutoPickService autoPickService, LottoService lottoService) {
        this.autoPickService = autoPickService;
        this.lottoService = lottoService;
    }

    public Round buy(Set<Pick> myPicks) {
        validate(myPicks);
        Round round = new Round();
        round.addPicks(myPicks);
        return round;
    }

    private void validate(Set<Pick> picks) {
        LottoConstraint constraint = lottoService.getConstraint();
        picks.forEach(constraint::validate);
    }

    public Round autoBuy(int count) {
        Set<Pick> picks = new HashSet<>();
        IntStream.range(0,count).forEach(i -> picks.add(autoPickService.pick()));
        return buy(picks);
    }
}
