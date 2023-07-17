package lotto.view;

import lotto.model.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoOutputView {

    private static final String LOTTO_RESULT_MESSAGE_FORMAT = "%d개 일치%s(%d원) - %d";

    private static final LottoOutputView INSTANCE = new LottoOutputView();

    private LottoOutputView() {
    }

    public static LottoOutputView getInstance() {
        return INSTANCE;
    }

    public void printBuyingLotto(final Lottos lottos) {
        lottos.getLottos().forEach(
                lotto -> System.out.println("[" + toLottoOutput(lotto) + "]")
        );
        System.out.println();
    }

    public void printLottoResult(final LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------------");

        for (final Rank rank : totalRanks()) {
            printRankResult(lottoResult, rank);
        }

        final double profitRate = lottoResult.getProfitRate().getValue();
        System.out.printf("총 수익률은 %.2f 입니다. ", profitRate);
        System.out.println(profitRateResult(profitRate));
    }

    public void printSizeOfLottos(final LottosSize lottos) {
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구입했습니다.", lottos.getManualSize(), lottos.getAutomaticSize()).println();
    }

    public void printChangeOfPurchase(final LottoMoney change) {
        System.out.printf("거스름돈은 %d원 입니다.", change.getValue()).println();
    }

    private void printRankResult(final LottoResult lottoResult, final Rank rank) {
        final int matchCount = rank.getMatchCount();
        final String bonusBallMessage = bonusBallMessage(rank);
        final long prize = rank.getPrize();
        final int count = lottoResult.getCount(rank);

        System.out.printf(LOTTO_RESULT_MESSAGE_FORMAT, matchCount, bonusBallMessage, prize, count).println();
    }

    private static List<Rank> totalRanks() {
        final List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        return ranks.subList(1, ranks.size());
    }

    private String bonusBallMessage(final Rank rank) {
        if (rank.isHasBonusBall()) {
            return ", (보너스 볼 일치)";
        }
        return "";
    }

    private String toLottoOutput(final Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", "));
    }

    private String profitRateResult(final double profitRate) {
        if (profitRate < 1) {
            return "(1 미만이므로 손해보셨습니다. 축하드립니다 ^^)";
        }
        return "(1 이상이므로 이득이네요. 좋겠네요.)";
    }
}
