package lotto;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketCount() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
        System.out.println();
    }
}
