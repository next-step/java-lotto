package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoBonusBall;
import lotto.view.LottoQuestion;
import lotto.view.LottoWinNumber;

public class LottoController {
    public static void main(String[] args) {

        LottoQuestion lottoQuestion = LottoQuestion.inputLottoPrice();
        LottoMachine lottoMachine = new LottoMachine(lottoQuestion.getPrice());
        LottoWinNumber lottoWinNumber = LottoWinNumber.lottoWinNumber();
        LottoBonusBall lottoBonusBall = LottoBonusBall.lottoBonusBall();
        WinLottoNumber winLottoNumber = new WinLottoNumber(lottoWinNumber.getLottoNumber(), lottoBonusBall.getBonusBall());
        new LottoResult(lottoMachine.getPurchasesLottoList(), lottoQuestion.getPrice(), winLottoNumber);
    }
}
