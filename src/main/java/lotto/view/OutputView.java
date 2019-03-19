package lotto.view;

import lotto.LottoTicket;

import java.util.List;

public class OutputView {


    public static void numberOfTickets(int amount) {
        System.out.println(amount / 1000 + "개를 구매했습니다.");
    }



    public static void buyLottoNumberPrint(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

//    public static void printWinningNumber(String winningNumber) {
//        System.out.println(winningNumber);
//    }



}
