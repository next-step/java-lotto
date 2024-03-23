package lotto.domain;

public class IssuedLottoTickets {

    private final LottoTickets manual;
    private final LottoTickets auto;

    public IssuedLottoTickets(LottoTickets manual, LottoTickets auto) {
        this.manual = manual;
        this.auto = auto;
    }

    public LottoTickets getManual() {
        return this.manual;
    }

    public LottoTickets getAuto() {
        return this.auto;
    }

    public int manualSize() {
        return this.manual.size();
    }

    public int autoSize() {
        return this.auto.size();
    }

}
