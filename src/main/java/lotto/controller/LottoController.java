package lotto.controller;

import lotto.model.*;
import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private int expense;
    private int numLottoTicket;

    public LottoController(int expense, int numLottoTicket) {
        this.expense = expense;
        this.numLottoTicket = numLottoTicket;
    }

    public List<LottoTicket> generate(){
        LottoGenerator lottoGenerator = new LottoGenerator(numLottoTicket, new RandomGenerateRule());
        List<LottoTicket> userLottoTickets = lottoGenerator.generateAll();
        return userLottoTickets;
    }

    public LottoResult run(List<LottoTicket> userLottoTickets) {
        List<LottoNumber> winningNumbers = ViewInput.getWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets, expense);
        LottoResult lottoResult = lottoGame.getLottoResult();
        return lottoResult;
    }
}
