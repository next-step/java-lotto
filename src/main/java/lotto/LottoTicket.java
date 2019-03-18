package lotto;

import java.util.List;

public class LottoTicket {

    private List<Integer> buyLottoNumbers;

    public LottoTicket(List<Integer> buyLottoNumbers) {
        this.buyLottoNumbers = buyLottoNumbers;
    }

    public List<Integer> getBuyLottoNumbers() {
        return buyLottoNumbers;
    }

    @Override
    public String toString() {
        return " " +
             buyLottoNumbers +
            " ";
    }
}
