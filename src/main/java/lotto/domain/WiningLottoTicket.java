package lotto.domain;

public class WiningLottoTicket {
    private LottoTicket winingNumber;
    private LottoNumber bonusNumber;


    public WiningLottoTicket(LottoTicket winningNumber, LottoNumber bonusNumber) {
        this.winingNumber = winningNumber;
        if (winningNumber.getLottoTicket().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스숫자 중복");
        }
        this.bonusNumber = bonusNumber;
    }


    public int checkLottoNumber(LottoTicket userLottoTicket) {
        int matchCont = 0;
        for (LottoNumber userLottoNumber: userLottoTicket.getLottoTicket()) {
            if (winingNumber.getLottoTicket().contains(userLottoNumber)) {
                matchCont++;
            }
        }
        return matchCont;
    }

    public boolean checkBonusNumber(LottoTicket buyUserLottoTicket) {
        return buyUserLottoTicket.getLottoTicket().contains(this.bonusNumber);
    }
}
