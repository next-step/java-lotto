package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String ANSWER_STATICS = "당첨 통계";
    private static final String LINE = "---------";
    private static final String NEW_LINE = System.lineSeparator();


    public static void showLottos(Lottos lottos) {
        printLotto(lottos);
    }

    private static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getValue()) {
            System.out.println(joinWithDelimiter(lotto));
        }
    }

    private static String joinWithDelimiter(Lotto lotto) {
        return lotto.getValue().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
    }

    public static void showRanks(LottoResult lottoResult, LottoFee lottoFee) {
        System.out.println(createResult(lottoResult, lottoFee));
    }

    private static String createResult(LottoResult lottoResult, LottoFee lottoFee) {
        StringBuilder result = new StringBuilder();
        result.append(ANSWER_STATICS).append(NEW_LINE).append(LINE).append(NEW_LINE);

        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        Collections.reverse(ranks);
        for (int i = 1; i < ranks.size(); i++) {
            LottoRank rank = ranks.get(i);
            result.append(createRankingForm(lottoResult,rank)).append(NEW_LINE);
        }
        result.append(createMarginForm(lottoResult, lottoFee)).append(NEW_LINE);
        return result.toString();
    }

    private static String createMarginForm(LottoResult lottoResult, LottoFee lottoFee) {
        float marginRate = lottoResult.getMargin(lottoFee.getValue());
        return "총 수익률은 " + marginRate + "입니다.(기준이 1이기 때문에 결과적으로 " + lossOrgain(marginRate) + "라는 의미임)";
    }

    private static String lossOrgain(float marginRate) {
        if (marginRate > 1) {
            return "이득이";
        }
        return "손해";
    }

    private static String createRankingForm(LottoResult lottoResult, LottoRank lottoRank) {
        int count = (int) lottoResult.getLottoRanks().stream()
                .filter(rank -> lottoRank == rank)
                .count();
        if (lottoRank == LottoRank.SECOND) {
            return lottoRank.matchCount() + "개 일치, 보너스 볼 일치 (" + lottoRank.prizeMoney() + ")-" + lottoResult.count(lottoRank) + "개";
        }
        return lottoRank.matchCount() + "개 일치 (" + lottoRank.prizeMoney() + ")-" + lottoResult.count(lottoRank) + "개";
    }
}
