package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final int numOfLottoTicket;

    private final DefaultLottoNumber defaultLottoNumber;

    public LottoGame(int numOfLottoTicket) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.defaultLottoNumber = new DefaultLottoNumber();
    }

    public LottoResults executeGame() {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (int genNum = 0; genNum < numOfLottoTicket; genNum++) {
            defaultLottoNumber.mixLottoNumbers();

            List<Integer> extractedNumbers = defaultLottoNumber.extractLottoNumbers();
            Collections.sort(extractedNumbers);
            lottoResults.add(new LottoResult(extractedNumbers));
        }
        return new LottoResults(lottoResults);
    }
}
