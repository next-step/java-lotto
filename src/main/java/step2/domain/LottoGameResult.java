package step2.domain;

import java.util.Map;

public class LottoGameResult {

    public LottoGameResult() {
    }

    public LottoGameResultDto getResult(LottoSheet lottoSheet,
        WinningLotto winningLotto,
        UserPrice userPrice) {

        Map<Prize, Integer> prizeResult = lottoSheet.getPrizeResult(winningLotto);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottoSheet, winningLotto),
            prizeResult);
    }
}
