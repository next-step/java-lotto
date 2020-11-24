package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.Rank;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RoundService {

    private final AutoPickService autoPickService;
    private final LottoService lottoService;

    private final Round round = new Round();

    public RoundService(AutoPickService autoPickService, LottoService lottoService) {
        this.autoPickService = autoPickService;
        this.lottoService = lottoService;
    }

    public Round buy(Set<Pick> myPicks) {
        round.addPicks(myPicks);
        validate();
        return round;
    }

    private void validate() {
        LottoConstraint constraint = lottoService.getConstraint();
        round.getMyPicks().stream()
                .map(Pick::getBalls)
                .forEach(constraint::validate);
    }

    public Round autoBuy(int count) {
        Set<Pick> picks = new HashSet<>();
        IntStream.range(0,count).forEach(i -> picks.add(autoPickService.pick()));
        return buy(picks);
    }

    public void checkWinning(Collection<Integer> winningBalls) {
        round.getMyPicks().forEach(pick -> {
            Rank rank = lottoService.checkRank(pick, winningBalls);
            pick.setRank(rank);
        });
    }

    public LottoReport generateReport() {
        return round.generateReport(lottoService.getPrice(), lottoService.getPrizeMap());
    }
}
