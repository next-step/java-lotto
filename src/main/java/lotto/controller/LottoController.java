package lotto.controller;

import lotto.model.*;
import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public LottoController() {
    }

    public List<LottoTicket> generate(int numLottoTicket){
        LottoGenerator lottoGenerator = new LottoGenerator(numLottoTicket, new RandomGenerateRule());
        List<LottoTicket> userLottoTickets = lottoGenerator.generateAll();
        return userLottoTickets;
    }

    public LottoResult run(LottoTicket winningTicket, List<LottoTicket> userLottoTickets, int expense) {

        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets, expense);
        LottoResult lottoResult = lottoGame.getLottoResult();
        return lottoResult;
    }
}
