package lottoauto.view;

import static lottoauto.model.Constant.Result.*;

import java.util.Map;
import java.util.stream.Collectors;
import lottoauto.model.Lotto;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningReward;

public class ResultView {

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(printNumber(lotto));
        }
    }

    private String printNumber(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELEGATOR, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        
        lottoResult.getMatchFrequency().forEach((match, count) -> {
            WinningReward rewardByMatches = WinningReward.findRewardByMatches(match);
            System.out.printf("%d개 일치 (%d원) - %d개\n", match, rewardByMatches.getReward(), count);
        });

        System.out.printf("총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임.)", lottoResult.calculateRate());

    }

}
