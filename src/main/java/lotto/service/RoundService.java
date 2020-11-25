package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.Rank;

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
        return round;
    }

    public Round autoBuy(int count) {
        Set<Pick> picks = new HashSet<>();
        IntStream.range(0,count).forEach(i -> picks.add(autoPickService.pick()));
        return buy(picks);
    }

    public void checkWinning(WinningLottoBalls winningBalls) {
        round.getMyPicks().forEach(pick -> {
            Rank rank = lottoService.checkRank(pick, winningBalls);
            pick.setRank(rank);
        });
    }

    public LottoReport generateReport() {
        return round.generateReport(lottoService.getPrice(), lottoService.getPrizeMap());
    }
}
