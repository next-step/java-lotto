package lotto;

import java.util.List;

public class WiningLottoTicket {
    private List<Integer> winingNumber;

    public WiningLottoTicket(List<Integer> winningNumber) {
        this.winingNumber = winningNumber;
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

    public List<Integer> getWiningNumber() {
        return winingNumber;
    }



}
