package lotto;

public class LottoTicket {
    private static String lottoTicketNumber;
    private int     winLevel = 0;

    public LottoTicket(String lottoNumber) {
        lottoTicketNumber = lottoNumber;
    }

    public String getLottoNumber() {
        return lottoTicketNumber;
    }
    public void setWinLevel (int winLevel) {
        this.winLevel = winLevel;
    }
}
