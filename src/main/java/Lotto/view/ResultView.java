package Lotto.view;

import Lotto.domain.Lottos;
import Lotto.domain.WinningRankInfo;
import Lotto.exception.NotFoundRankException;

import java.util.Map;
import java.util.stream.Stream;

enum ResultRankMessage {
    FIRST(WinningRankInfo.FIRST,"6개 일치 (2000000000원)"),
    SECOND(WinningRankInfo.SECOND, "5개 일치 (1500000원)"),
    THIRD(WinningRankInfo.THIRD, "4개 일치 (50000원)"),
    FOURTH(WinningRankInfo.FOURTH, "3개 일치 (5000원)"),
    FIFTH(WinningRankInfo.FIFTH,  ""),
    SIX(WinningRankInfo.SIX,  ""),
    NONE(WinningRankInfo.NONE,  "");

    private final WinningRankInfo rankInfo;
    private final String resultMessage;

    ResultRankMessage(WinningRankInfo rankInfo, String message) {
        this.rankInfo = rankInfo;
        this.resultMessage = message;
    }

    public static ResultRankMessage findRankMessage(WinningRankInfo rankInfo) {
        return Stream.of(values())
                .filter(ResultRankMessage -> (ResultRankMessage.rankInfo == (rankInfo)))
                .findFirst()
                .orElseThrow(() -> new NotFoundRankException("등수를 찾을 수 없습니다."));
    }

    public String getRankMessage() { return resultMessage; }
}


public class ResultView {

    private ResultView() {}

    private static int LOTTO_LAST_NUMBER = 6;

    public static void viewLottoNumbers(Lottos lottos) {
        int lottoNum = lottos.getLottoCnt();
        System.out.println(lottoNum + "개를 구매했습니다.");

        for (int i = 0; i < lottoNum; ++i) {
            System.out.print("[");
            viewLottoNumbers(lottos, i);
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    private static void viewLottoNumbers(Lottos lottos, int i) {
        for (int j = 0; j < LOTTO_LAST_NUMBER; ++j) {
            System.out.print(lottos.getLotto(i).getLottoNumber(j));
            if (j < LOTTO_LAST_NUMBER - 1)
                System.out.print(", ");
        }
    }

    public static void viewResultBoard(Map<WinningRankInfo, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (WinningRankInfo rank : result.keySet()) {
            viewResultMessage(result, rank);
        }
    }

    private static void viewResultMessage(Map<WinningRankInfo, Integer> result, WinningRankInfo rank) {
        if (rank.isValidRank()) {
            ResultRankMessage rankMessage = ResultRankMessage.findRankMessage(rank);
            System.out.println(rankMessage.getRankMessage() + "- " + result.get(rank) + "개");
        }
    }

    public static void viewLottoYield(double yield) {
        System.out.println("총 수익율은 " + yield + "입니다.");
    }
}
