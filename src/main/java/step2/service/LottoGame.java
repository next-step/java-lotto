package step2.service;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
    }

    public List<Lotto> executeGame() {
        List<Lotto> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            lottoResults.add(new Lotto(LottoNumberGenerator.generateSixNumbers()));
        }

        return lottoResults;
    }
}
