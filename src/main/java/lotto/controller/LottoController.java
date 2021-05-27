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
        //TODO: 사용자 입력 생성으로 변경
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets, expense);
        LottoResult lottoResult = lottoGame.getLottoResult();
        return lottoResult;
    }
}
