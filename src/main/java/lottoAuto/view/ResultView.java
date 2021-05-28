package lottoAuto.view;

import lottoAuto.model.*;
import lottoAuto.vo.LottoResultVo;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private InputView inputView = new InputView();

    public int showAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }

    public void showUserLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public Map<Rank, Long> showWinningStatistic(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        Map<Rank, Long> collect = lottoResults.getLottoResult().stream().collect(Collectors.groupingBy(x -> Rank.findByRank(x), Collectors.counting()));
        collect.entrySet().stream().forEach(rankLongEntry -> System.out.println(Rank.getMessage(rankLongEntry.getKey()) + " - " + rankLongEntry.getValue()));
        return collect;
    }

}
