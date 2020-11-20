package lotto.controller;

import lotto.domain.LottoConstraint;
import lotto.domain.Round;
import lotto.service.LottoService;
import lotto.service.RoundService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collection;
import java.util.List;

public class RoundController {
    private final RoundService roundService;
    private final LottoService lottoService;
    private final InputView inputView = new InputView();

    public RoundController(RoundService roundService, LottoService lottoService) {
        this.roundService = roundService;
        this.lottoService = lottoService;
    }

    public Round autoBuy(Long budget) {
        Integer price = lottoService.getPrice();
        int pickCount = Math.toIntExact(budget / price.longValue());
        return roundService.autoBuy(pickCount);
    }

    public void checkWinning(Collection<Integer> winningBalls) {
        LottoConstraint constraint = lottoService.getConstraint();
        constraint.validate(winningBalls);
        roundService.checkWinning(winningBalls);
    }

    public void buyView() {
        Long budget = inputView.getLong("구입금액을 입력해 주세요.");
        Round round = autoBuy(budget);
        ResultView.myPick(round.getMyPicks());
    }

    public void checkView() {
        List<Integer> winningBalls = inputView.getCommaSeparatedInteger("지난 주 당첨 번호를 입력해 주세요.");
        checkWinning(winningBalls);
    }
}
