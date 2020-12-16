package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class LottoGame {

    public LottoTickets generateLottoTickets(int price, LottoMachine lottoMachine) {
        return lottoMachine.generate(price);
    }

    public WinningNumber generateWinningNumber(String inputNumber, LottoMachine lottoMachine) {
        return lottoMachine.winningNumber(inputNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber);
    }
}
