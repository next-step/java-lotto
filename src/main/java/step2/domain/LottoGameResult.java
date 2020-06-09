package step2.domain;

import static step2.Constants.EMPTY_COUNT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {

    private Map<Integer, Integer> prizeResult;

    public LottoGameResult() {
        prizeResult = new HashMap<>();
        Arrays.stream(Prize.values())
            .forEach(prize -> prizeResult.put(prize.getGrade(), EMPTY_COUNT));
    }

    public LottoGameResultDto getResult(LottoSheet lottoSheet, WinningLotto winningLotto,
        UserPrice userPrice) {

        lottoSheet.drawPrize(winningLotto, prizeResult);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottoSheet, winningLotto),
            prizeResult);
    }
}
