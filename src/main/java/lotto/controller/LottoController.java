package lotto.controller;

import lotto.model.*;
import lotto.view.ViewInput;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    public static LottoResult run() {
        int expense = ViewInput.getExpense();
        int numLottoTicket = ViewInput.getAvailableNumLottoTicket(expense);
        LottoGenerator lottoGenerator = new LottoGenerator(numLottoTicket, new RandomGenerateRule());
        List<LottoTicket> userLottoTickets = lottoGenerator.generateAll();
        List<LottoNumber> winningNumbers = ViewInput.getWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets, expense);
        LottoResult lottoResult = lottoGame.getLottoResult();
        return lottoResult;
    }
}
