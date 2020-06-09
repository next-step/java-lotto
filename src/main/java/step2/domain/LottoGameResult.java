package step2.domain;

import static step2.Constants.EMPTY_COUNT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {

    private Map<Integer, Integer> prizeResult;

    public LottoGameResult() {
        prizeResult = new HashMap<>();
        Arrays.stream(Prize.values())
            .forEach(prize -> prizeResult.put(prize.getGrade(), EMPTY_COUNT));
    }

    public LottoGameResultDto getResult(List<UserLotto> lottos, WinningLotto winningLotto,
        UserPrice userPrice) {

        drawPrize(lottos, winningLotto);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottos, winningLotto),
            prizeResult);
    }

    private void drawPrize(List<UserLotto> lottos, WinningLotto winningLotto) {

        lottos.stream().forEach(lotto -> {
                Prize prize = lotto.getPrize(winningLotto);
                this.prizeResult
                    .put(prize.getGrade(), prizeResult.get(prize.getGrade()).intValue() + 1);
            }
        );
    }
}
