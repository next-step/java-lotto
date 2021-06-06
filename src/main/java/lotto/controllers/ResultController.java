package lotto.controllers;

import lotto.domains.Scores;
import lotto.domains.EarningRate;
import lotto.domains.Tickets;
import lotto.domains.WinningNumbers;
import lotto.views.Reporter;

public final class ResultController {

    private ResultController() {
    }

    public static void run(Tickets tickets, WinningNumbers winningNumbers) {
        Scores scores = tickets.scores(winningNumbers);
        EarningRate earningRate = new EarningRate(scores, tickets);

        Reporter.report(scores, earningRate);
    }

}
