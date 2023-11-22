package lotto.domain;

public class LottoMachine {
    public LottoTicket generateLottoTicket(int number) {
        LottoTicket lottoTicket = new LottoTicket(number);
        return lottoTicket;
    }
}
