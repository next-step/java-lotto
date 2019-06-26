package com.java.lotto.view;

import com.java.lotto.domain.Lotto;
import com.java.lotto.domain.LottoTicket;

public class ResultView {

    public static void outputOfPurchaseList(Lotto lotto) {
        System.out.println(lotto.getLottoTicketsCount() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lotto.getLottoTickets()) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

}
