package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWallet;

import java.util.List;
import java.util.StringJoiner;

public class PrintView {

    public void showStatusBuyTicket(LottoWallet lottoWallet) {
        List<LottoTicket> lottoTickets = lottoWallet.lottoTickets();
        System.out.println(lottoWallet.ticketCount() +"개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        StringJoiner lottoNumberJoiner = new StringJoiner(",", "[", "]");

        for (LottoNumber lottoNumber : lottoTicket.numbers()) {
            int number = lottoNumber.value();
            lottoNumberJoiner.add(String.valueOf(number));
        }

        System.out.println(lottoNumberJoiner.toString());
    }

    public void showLottoResult() {
        System.out.println("당첨통계");
        System.out.println("---------------");
        //결과화면
    }

}
