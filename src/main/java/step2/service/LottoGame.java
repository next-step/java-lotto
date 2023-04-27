package step2.service;

import step2.vo.LottoResults;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public LottoResults executeGame() {
        List<Lotto> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            lottoResults.add(lottoNumberGenerator.generateLottoNumbers());
        }
        return new LottoResults(lottoResults);
    }
}
