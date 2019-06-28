package step4.domain;

public class LuckyTicket {
    private final LottoTicket luckyTicket;
    private final LottoNumber bonusNumber;

    public LuckyTicket(LottoTicket luckyTicket, LottoNumber bonusNumber) {
        this.luckyTicket = luckyTicket;
        this.bonusNumber = bonusNumber;
    }

    public static LuckyTicket of(LottoTicket luckyTicket, LottoNumber bonusNumber) {
        return new LuckyTicket(luckyTicket, bonusNumber);
    }
}
