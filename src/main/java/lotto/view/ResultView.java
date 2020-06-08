package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static StringBuilder stringBuilder;

    public static void printLotto(List<Lotto> lottos, int countLotto) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(countLotto).append("개를 구매했습니다.\n");

        lottos.forEach(lotto -> {
            printLottoNumbers(lotto.getLottoNumbers());
            stringBuilder.append("\n");
        });
        System.out.println(stringBuilder.toString());
    }

    private static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        List<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        stringBuilder.append(numbers);
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
