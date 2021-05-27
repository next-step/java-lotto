package lotto.controller;

import lotto.model.*;

import java.util.List;

public class LottoController {

    public LottoController() {
    }

    public List<LottoTicket> generate(int numLottoTicket){
        LottoGenerator lottoGenerator = new LottoGenerator(numLottoTicket, new RandomGenerateRule());
        return lottoGenerator.generateBulk();
    }

    public LottoResult run(LottoTicket winningTicket, List<LottoTicket> userLottoTickets, int expense) {
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets);
        ScoreMap scoreMap = lottoGame.getScores();
        return new LottoResult(scoreMap, expense);
    }
}
