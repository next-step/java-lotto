package lotto.view;

import lotto.LottoTicket;

import java.util.List;

public class OutputView {


    public static void buyLottoNumberPrint(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }

    }


}
