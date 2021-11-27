package com.kakao.lotto;

import com.kakao.lotto.domain.*;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.RankStatistic;
import com.kakao.lotto.ui.InputView;
import com.kakao.lotto.ui.OutputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        int lottoPrice = inputView.inputLottoPrice();
        List<List<Integer>> pickedLotteries = inputView.inputPickedLotteries();
        PurchaseInfo purchaseInfo = new PurchaseInfo(lottoPrice, pickedLotteries);

        LottoMachine lottoMachine = new LottoMachine(purchaseInfo);
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTicket(lottoTickets, purchaseInfo);

        List<Integer> winLotto = inputView.inputWinLotto();
        int bonus = inputView.inputLottoBonus();
        WinLottoTicket winLottoTicket = WinLottoTicket.of(winLotto, bonus);

        RankStatistic rankStatistic = lottoTickets.createRankStatistic(winLottoTicket, purchaseInfo.getMoney());
        OutputView.printLottoWinStatistic(rankStatistic);

    }
}
