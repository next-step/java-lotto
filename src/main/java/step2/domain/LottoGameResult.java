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

        drawLottos(lottos, winningLotto);

        countPrize(lottos);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottos),
            prizeResult);
    }

    private void countPrize(List<UserLotto> lottos) {

        lottos.stream().forEach(lotto ->
            this.prizeResult.put(lotto.getPrize(), prizeResult.get(lotto.getPrize()).intValue() + 1)
        );
    }

    private void drawLottos(List<UserLotto> lottos, WinningLotto winningLotto) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningLotto));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
