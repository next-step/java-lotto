package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;

import java.util.Scanner;
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

    public static void showRanks(LottoRanks lottoRanks) {
        System.out.println(createResult(lottoRanks));
    }

    private static String createResult(LottoRanks lottoRanks) {
        String result = "";
        result += ANSWER_STATICS + NEW_LINE + LINE + NEW_LINE;
        result += createRankingForm(lottoRanks, LottoRank.FOURTH) + NEW_LINE;
        result += createRankingForm(lottoRanks, LottoRank.THIRD) + NEW_LINE;
        result += createRankingForm(lottoRanks, LottoRank.SECOND) + NEW_LINE;
        result += createRankingForm(lottoRanks, LottoRank.FIRST) + NEW_LINE;
        result += createMarginForm(lottoRanks) + NEW_LINE;
        return  result;
    }

    private static String createMarginForm(LottoRanks lottoRanks) {
        float marginRate = lottoRanks.getMargin();
        return "총 수익률은 " + marginRate + "입니다.(기준이 1이기 때문에 결과적으로 " + lossOrgain(marginRate) + "라는 의미임)";
    }

    private static String lossOrgain(float marginRate) {
        if (marginRate > 1) {
            return "이득이";
        }
        return "손해";
    }

    private static String createRankingForm(LottoRanks lottoRanks, LottoRank lottoRank) {
        int count = (int) lottoRanks.getLottoRanks().stream()
                .filter(rank -> lottoRank == rank)
                .count();
        return lottoRank.getMatchCount() + "개 일치 (" + lottoRank.getPrizeMoney() + ")-" + count;
    }
}
