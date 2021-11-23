package com.kakao.lotto;

import com.kakao.lotto.domain.*;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.domain.RankStatistic;
import com.kakao.lotto.supportInfo.WinResult;
import com.kakao.lotto.ui.InputView;
import com.kakao.lotto.ui.OutputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        PurchaseInfo purchaseInfo = new PurchaseInfo(inputView.inputLottoPurchase());
        LottoMachine lottoMachine = new LottoMachine(purchaseInfo);
        LottoTicketCollection lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTicket(lottoTickets);

        List<Integer> winLotto = inputView.inputWinLotto();
        int bonus = inputView.inputLottoBonus();
        WinLottoTicket winLottoTicket = WinLottoTicket.of(winLotto, bonus);

        RankStatistic rankStatistic = lottoTickets.createRankStatistic(winLottoTicket);
        WinResult winResult = rankStatistic.createWinResult(purchaseInfo);
        OutputView.printLottoWinStatistic(winResult);

    }
}
