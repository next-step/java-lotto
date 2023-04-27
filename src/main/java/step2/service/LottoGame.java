package step2.service;

import step2.vo.LottoResults;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    private final BasicLottoNumbers basicLottoNumbers;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.basicLottoNumbers = new BasicLottoNumbers();
    }

    public LottoResults executeGame() {
        List<Lotto> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            lottoResults.add(basicLottoNumbers.pickSixNumbers());
        }

        return new LottoResults(lottoResults);
    }
}
