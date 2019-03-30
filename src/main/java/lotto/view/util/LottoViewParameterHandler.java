package lotto.view.util;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoViewParameterHandler {

    public static List<String[]> toStringArrayList(String input) {
        if (input.equals("")) {
            return new ArrayList<>();
        }

        return Stream.of(input.split("\r\n"))
                .map(line -> line.split(","))
                .collect(Collectors.toList());
    }

    public static String[] toStringArray(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
        return input.split(",");
    }

    public static List<String> toStringList(LottoBundle lottoBundle) {
        List<String> viewDatas = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoBundle.getTickets()) {
            viewDatas.add(lottoTicket.toString());
        }
        return viewDatas;
    }

    public static List<String> toStringList(LottoMatcher lottoMatcher) {
        List<LottoRank> lottoRanks = sortLottoRank(lottoMatcher);
        List<String> rankResult = new ArrayList<>();
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank == LottoRank.MISS) continue;
            rankResult.add(determinePrintRankMessage(lottoMatcher, lottoRank));
        }
        return rankResult;
    }

    private static List<LottoRank> sortLottoRank(LottoMatcher lottoMatcher) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.addAll(lottoMatcher.getRankResult().keySet());
        Collections.sort(lottoRanks, Collections.reverseOrder());
        return lottoRanks;
    }

    private static String determinePrintRankMessage(LottoMatcher lottoMatcher, LottoRank lottoRank) {
        if (lottoRank.money == LottoRank.SECOND.money) {
            return new StringBuilder(lottoRank.matchCount + "개 일치, 보너스 볼 일치("
                    + lottoRank.money + "원) - " + lottoMatcher.getRankResult().get(lottoRank) + "개").toString();
        }

        return new StringBuilder(lottoRank.matchCount + "개 일치 ("
                + lottoRank.money + "원) - " + lottoMatcher.getRankResult().get(lottoRank) + "개").toString();
    }
}
