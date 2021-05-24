package controller;

import domain.*;
import view.InputView;

public class LottoGame {
    public LottoTickets generateLottoTickets(int price, LottoMachine lottoMachine) {
        return lottoMachine.generate(price);
    }

    public WinningNumber generateWinningNumber(String inputNumber, LottoMachine lottoMachine) {
        return InputView.winningNumber(inputNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber, LottoNumber bonusBall) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber, bonusBall);
    }

    public LottoNumber generateBonusBall(int inputNumber, LottoMachine lottoMachine, WinningNumber winningNumber) {
        return lottoMachine.bonusBall(inputNumber, winningNumber);
    }
}
