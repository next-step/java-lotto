package lotto.view;

import java.util.stream.Collectors;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMoney;
import lotto.model.domain.LottoResult;
import lotto.model.domain.Lottos;
import lotto.model.domain.Rank;

public final class LottoOutputView {

    private LottoOutputView() {
    }

    private static class LottoOutputViewHolder {

        private static final LottoOutputView INSTANCE = new LottoOutputView();

    }

    public static LottoOutputView getInstance() {
        return LottoOutputViewHolder.INSTANCE;
    }

    public void printBuyingCount(final LottoMoney lottoMoney) {
        System.out.println(lottoMoney.getCount() + "개를 구매했습니다.");
        System.out.println("거스름돈은 " + lottoMoney.getChange() + "원 입니다.");
    }

    public void printBuyingLotto(final Lottos lottos) {
        lottos.getLottos().forEach(
                lotto -> System.out.println("[" + toLottoOutput(lotto) + "]"));
        System.out.println();
    }

    public void printLottoResult(final LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------------");

        System.out.println("3개 일치 (5000원) - " + lottoResult.getCount(Rank.FIFTH));
        System.out.println("4개 일치 (50000원) - " + lottoResult.getCount(Rank.FOURTH));
        System.out.println("5개 일치 (1500000원) - " + lottoResult.getCount(Rank.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + lottoResult.getCount(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + lottoResult.getCount(Rank.FIRST));

        final double profitRate = lottoResult.getProfitRate();
        System.out.printf("총 수익률은 %.2f 입니다. ", profitRate);
        System.out.println(profitRateResult(profitRate));
    }

    private String toLottoOutput(final Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", "));
    }

    private String profitRateResult(final double profitRate) {
        if (profitRate < 1) {
            return "(1 미만이므로 손해보셨습니다. 다음을 노려보세요.)";
        }
        return "(1 이상이므로 이득보셨습니다. 축하합니다.)";
    }
}
