package lotto.domain;

public class WinTicket {

    private LottoTicket winTicket;
    private LottoNumber bonusNumber;

    public WinTicket(String text, int bonusInt) {
        this.winTicket = new LottoTicket(text);
        this.bonusNumber = LottoNumber.of(bonusInt);
    }

    public boolean winTicketContains(LottoNumber num) {
        return (winTicket.contains(num));
    }

    public boolean bonusContains(LottoNumber num) {
        return (bonusNumber.equals(num));
    }

}
