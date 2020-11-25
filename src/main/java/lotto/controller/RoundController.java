package lotto.controller;

import lotto.domain.LottoBalls;
import lotto.domain.Prize;
import lotto.domain.Round;
import lotto.domain.enums.Rank;
import lotto.service.LottoService;
import lotto.service.RoundService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class RoundController {
    private final RoundService roundService;
    private final LottoService lottoService;

    public RoundController(RoundService roundService, LottoService lottoService) {
        this.roundService = roundService;
        this.lottoService = lottoService;
    }

    public void buyView() {
        Long budget = InputView.getLong("구입금액을 입력해 주세요.");
        Round round = autoBuy(budget);
        ResultView.myPick(round.getMyPicks());
    }

    public Round autoBuy(Long budget) {
        Integer price = lottoService.getPrice();
        int pickCount = Math.toIntExact(budget / price.longValue());
        return roundService.autoBuy(pickCount);
    }

    public void checkWinningView() {
        List<Integer> winningBalls = InputView.getCommaSeparatedInteger("지난 주 당첨 번호를 입력해 주세요.");
        roundService.checkWinning(new LottoBalls(winningBalls));
    }

    public void reportView() {
        Map<Rank, Prize> prizeMap = lottoService.getPrizeMap();
        ResultView.report(prizeMap, roundService.generateReport());
    }
}
