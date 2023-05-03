package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Comparator;

public class ResultView {
    private ResultView() {
    }

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
                .mapToInt(LottoNumber::getNumber)
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

        Arrays.stream(LottoPrize.values())
                .sorted(Comparator.comparing(LottoPrize::getPrize))
                .forEachOrdered(it -> stringBuilder.append(getMessageForPrize(lottoResult, it)));

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

    private static String getMessageForPrize(LottoResult lottoResult, LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.NONE) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoPrize.getMatchingCount());
        stringBuilder.append("개 일치");
        stringBuilder.append(getMessageForBonus(lottoPrize));
        stringBuilder.append(lottoPrize.getPrize());
        stringBuilder.append("원)- ");
        stringBuilder.append(lottoResult.getMatchingLottosCount(lottoPrize));
        stringBuilder.append("개\n");

        return stringBuilder.toString();
    }

    private static String getMessageForBonus(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.SECOND) {
            return ", 보너스 볼 일치(";
        }

        return " (";
    }
}
