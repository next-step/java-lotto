package com.kakao.lotto;

import com.kakao.lotto.domain.LottoMachine;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.ui.InputView;
import com.kakao.lotto.ui.OutputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        PurchaseInfo purchaseInfo = new PurchaseInfo(inputView.inputLottoPerchase());
        LottoMachine lottoMachine = new LottoMachine(purchaseInfo);
        List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTicket(lottoTickets);

    }
}
