package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoBonusRequest;
import lotto.view.LottoPurchaseRequest;
import lotto.view.PassivityLottoNumberRequest;
import lotto.view.WinLottoRequest;

public class LottoController {
    public static void main(String[] args) {

        LottoPurchaseRequest lottoPurchaseRequest = LottoPurchaseRequest.inputLottoPrice();
        LottoPurchases lottoPurchases = new LottoPurchases(lottoPurchaseRequest.getLottoPriceCount(), lottoPurchaseRequest.getPassivityPurchasesCount());
        PassivityLottoNumberRequest passivityLottoNumberRequest = PassivityLottoNumberRequest.inputLottoPrice(lottoPurchases.getPassivityCount());
        LottoMachine lottoMachine = new LottoMachine(lottoPurchases, passivityLottoNumberRequest.getPassivityLottoNumberList());
        WinLottoRequest winLottoRequest = WinLottoRequest.lottoWinNumber();
        LottoBonusRequest lottoBonusRequest = LottoBonusRequest.lottoBonusBall();
        WinLottoNumber winLottoNumber = new WinLottoNumber(winLottoRequest.getLottoNumber(), lottoBonusRequest.getBonusBall());
        new LottoResult(lottoMachine.getPurchasesLottoList(), lottoPurchaseRequest.getLottoPriceCount(), winLottoNumber);
    }
}
