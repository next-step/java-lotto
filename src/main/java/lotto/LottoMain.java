package lotto;


import lotto.domain.LottoMatcher;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMain {

    public static void main(String[] args) {
        int purchaseAmount = Integer.parseInt(InputView.getPurchaseAmount());
        int tempPurchaseAmount = purchaseAmount;
        List<LottoTicket> lottoTickets = new ArrayList<>();
        while(tempPurchaseAmount > 0){
            LottoTicket lottoTicket = new LottoTicket();
            lottoTicket.pickAuto();
            lottoTickets.add(lottoTicket);
            System.out.println(lottoTicket.toIntegerList());
            tempPurchaseAmount -= LottoTicket.PRICE;
        }
        String winningTicket = InputView.getWinningNumber();
        String[] winningTicketArray = winningTicket.split(", ");

        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        for( String winningNumber : winningTicketArray){
            Integer num = Integer.parseInt(winningNumber);
            lottoNumberSet.add(new LottoNumber(num));
        }
        LottoTicket winningTickets = new LottoTicket(lottoNumberSet);
        LottoNumber bonusNum = new LottoNumber(Integer.parseInt(InputView.getBonusNumber()));

        LottoMemo lottoMemo = new LottoMemo();
        LottoMatcher lottoMatcher = new LottoMatcher(winningTickets, bonusNum);
        for(LottoTicket lottoTicket : lottoTickets){
            lottoMatcher.match(lottoTicket);
            lottoTicket.markResult(lottoMatcher.getMatchCount(), lottoMatcher.isMatchBouns());
            lottoMemo.markResult(lottoTicket.getLottoResult());
        }
        ResultView.method1(lottoMemo, purchaseAmount);
    }

}
