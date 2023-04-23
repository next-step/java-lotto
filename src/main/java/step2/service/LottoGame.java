package step2.service;

import step2.vo.LottoResult;
import step2.vo.LottoResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    private final LottoNumber lottoNumber;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.lottoNumber = new DefaultLottoNumber();
    }

    public LottoResults executeGame() {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            List<Integer> extractedNumbers = lottoNumber.extractLottoNumbers();
            Collections.sort(extractedNumbers);
            lottoResults.add(new LottoResult(extractedNumbers));
        }
        return new LottoResults(lottoResults);
    }
}
