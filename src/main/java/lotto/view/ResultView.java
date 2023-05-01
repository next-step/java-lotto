package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class ResultView {
    public static void showLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.getLottoQuantity());
        stringBuilder.append("개를 구매했습니다.");

        System.out.println(stringBuilder);

        lottos.getLottoList()
                .forEach(ResultView::showLotto);
        System.out.println();
    }

    private static void showLotto(Lotto lotto) {
        int[] lottoNumbers = lotto.getLottoNumberSet()
                .stream()
                .mapToInt(it -> it)
                .sorted()
                .toArray();

        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < Lotto.LOTTO_NUMBER_SIZE - 1; i++) {
            stringBuilder.append(lottoNumbers[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(lottoNumbers[Lotto.LOTTO_NUMBER_SIZE - 1]);
        stringBuilder.append(']');

        System.out.println(stringBuilder);
    }

    public static void showResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n당첨 통계\n");
        stringBuilder.append("---------\n");

        for (int i = 3; i <= 6; i++) {
            stringBuilder.append(i);
            stringBuilder.append("개 일치 (");
            stringBuilder.append(LottoPrize.from(i).getPrize());
            stringBuilder.append("원)- ");
            stringBuilder.append(lottoResult.getMatchingLottosCount(i));
            stringBuilder.append("개\n");
        }

        stringBuilder.append("총 수익률은 ");
        double profitRate = lottoResult.getProfitRate();
        stringBuilder.append(profitRate);
        stringBuilder.append("입니다.(기준이 1이기 때문에 결과적으로 ");
        if (profitRate < 1) {
            stringBuilder.append("손해라는 의미임)");
        }

        if (profitRate == 1) {
            stringBuilder.append("본전이라는 의미임)");
        }

        if (profitRate > 1) {
            stringBuilder.append("이득이라는 의미임)");
        }

        System.out.println(stringBuilder);
    }
}
