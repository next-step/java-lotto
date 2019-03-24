package lotto.domain;

import java.util.List;

public class WiningLottoTicket {
    private List<Integer> winingNumber;
    private int bonusNumber;


    public WiningLottoTicket(List<Integer> winningNumber, int bonusNumber) {
        this.winingNumber = winningNumber;
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스숫자 중복");
        }
        this.bonusNumber = bonusNumber;
    }


    public int checkLottoNumber(LottoTicket lottoTicket) {
        int matchCont = 0;
        for (Integer lottoNumber : lottoTicket.getLottoTicket()) {
            if (winingNumber.contains(lottoNumber)) {
                matchCont++;
            }
        }
        return matchCont;
    }

    public boolean checkBonusNumber(LottoTicket buyLottoTicket) {
        return buyLottoTicket.getLottoTicket().contains(bonusNumber);
    }

    public List<Integer> getWiningNumber() {
        return winingNumber;
    }



}
