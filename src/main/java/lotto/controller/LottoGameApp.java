package lotto.controller;

import lotto.model.LotteryTicket;
import lotto.model.LotteryTickets;
import lotto.model.PurchaseInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoGameApp {

    public static void main(String[] args) {
        try {
            int amount = InputView.getIntValue("구입금액을 입력해 주세요.");
            PurchaseInfo purchaseInfo = new PurchaseInfo(amount);
            ResultView.purchaseCount(purchaseInfo.getLottoCount());
            ResultView.printTickets(new LotteryTickets(purchaseInfo.getLottoCount()));
            List<Integer> winning = InputView.getCommaSplitIntList("지난 주 당첨 번호를 입력해 주세요.");
            LotteryTicket winningTicket = new LotteryTicket(winning);

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }
}
