package lotto.view;

import lotto.domain.LottoMatcher;
import lotto.domain.Lottos;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.Map;

public class ResultView {
    private static StringBuilder stringBuilder;

    public static void printLottoNumbers(Lottos lottos) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.getLottoCount()).append("개를 구매했습니다.\n");

        lottos.getLottos().forEach(lottoNumber -> {
            stringBuilder.append(lottoNumber.getNumbers());
            stringBuilder.append("\n");
        });
        System.out.println(stringBuilder.toString());
    }

    public static void printResult(LottoMatcher lottoMatcher, int money) {
        stringBuilder = new StringBuilder();
        LottoResult lottoResult = new LottoResult(lottoMatcher.getLottoPrizeList());
        Map<Integer, Integer> matchLottoResult = lottoResult.matchResult();

        stringBuilder.append("당첨 통계\n");
        stringBuilder.append("---------\n");
        for (int idx = 3; idx <= 6; idx++) {
            stringBuilder.append(idx);
            stringBuilder.append("개 일치 (");
            stringBuilder.append(LottoPrize.valueOf(idx).getPrize());
            stringBuilder.append("원)- ");
            stringBuilder.append(matchLottoResult.getOrDefault(idx, 0));
            stringBuilder.append("개\n");
        }
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(lottoResult.statistics(money));
        stringBuilder.append("입니다.");
        System.out.println(stringBuilder.toString());
    }
}
