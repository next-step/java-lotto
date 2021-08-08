package lotto.model;

import java.util.List;

public class LottoTicket {

    private List<LottoNumbers> lottoNumberList;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoNumberList = lottoNumbers;
    }

    public LottoTicket generateNumbers(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoNumberList.add(lottoNumbers.generateNumbers());
        }
        return this;
    }

    public List<LottoNumbers> getTicketInfo() {
        return this.lottoNumberList;
    }

}
