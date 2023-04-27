package step2.service;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    private final BasicLottoNumbers basicLottoNumbers;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.basicLottoNumbers = new BasicLottoNumbers();
    }

    public List<Lotto> executeGame() {
        List<Lotto> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            lottoResults.add(new Lotto(basicLottoNumbers.pickSixNumbers()));
        }

        return lottoResults;
    }
}
