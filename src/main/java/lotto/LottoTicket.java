package lotto;

public class LottoTicket {
    private static String lottoTicketNumber;

    public LottoTicket(String lottoNumber) {
        lottoTicketNumber = lottoNumber;
    }

    public String getLottoNumber() {
        return lottoTicketNumber;
    }
}
