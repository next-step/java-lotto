package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.PrizeCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void showPurchasedLotto(List<Lotto> lottoSession, int manualCount) {
        StringBuilder stringBuilder = new StringBuilder();

        if (manualCount > 0) {
            stringBuilder.append("수동으로 ").append(manualCount).append("장 ");
        }

        if (lottoSession.size() - manualCount > 0) {
            stringBuilder.append("자동으로 ").append(lottoSession.size() - manualCount).append("장");
        }

        stringBuilder.append("을 구매했습니다.\n");

        for (Lotto lotto : lottoSession) {
            stringBuilder.append(lotto.getLottoNumbers()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void showResult(Map<LottoRank, Long> result) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n당첨 통계\n-----------\n");

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.LOSE)
                        .forEach(rank -> stringBuilder.append(getResultMessage(rank)).append(result.getOrDefault(rank, 0L)).append("개").append("\n"));
        System.out.println(stringBuilder);
    }

    private static String getResultMessage(LottoRank lottoRank) {
        switch (lottoRank) {
            case FOURTH:
                return "3개 일치 (5000원)-";
            case THIRD:
                return "4개 일치 (50000원)-";
            case SECOND:
                return "5개 일치 (1500000원)-";
            case SECOND_BONUS:
                return "5개 일치, 보너스 볼 일치(30000000원)-";
            case FIRST:
                return "6개 일치 (2000000000원)-";
        }

        return null;
    }


    public static void showROR(Map<LottoRank, Long> result, int purchaseAmount) {
        System.out.println("총 수익률은 " + (double) PrizeCalculator.getPrize(result) / purchaseAmount + "입니다.");
    }
}
