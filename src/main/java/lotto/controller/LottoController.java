package lotto.controller;

import lotto.model.*;
import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public LottoController() {
        //MEMO: expense를 알고 있어야 함.
    }

    public List<LottoTicket> generate(int numLottoTicket){
        LottoGenerator lottoGenerator = new LottoGenerator(numLottoTicket, new RandomGenerateRule());
        List<LottoTicket> userLottoTickets = lottoGenerator.generateAll();
        return userLottoTickets;
    }

    public LottoResult run(LottoTicket winningTicket, List<LottoTicket> userLottoTickets, int expense) {
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets);
        ScoreMap scoreMap = lottoGame.getLottoResult();
        return new LottoResult(scoreMap, expense);
    }
}
