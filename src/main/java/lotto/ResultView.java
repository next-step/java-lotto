package lotto;

public class ResultView {
    public static void printCount(int count) {
        System.out.println(count + "개를 구입하였습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        for (String lottoString : lottos.toStringLottos()) {
            System.out.println(lottoString);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (LottoRank rank : LottoRank.ranks()) {
            System.out.println(infoString(lottoResult, rank));
        }
        double profitRate = lottoResult.profitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.");
        if (profitRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String infoString(LottoResult lottoResult, LottoRank rank) {
        String countString = rank.getMatchCount() + "개 일치";
        if (rank == LottoRank.SECOND) countString += ", 보너스 볼 일치";
        String rewordString = " (" + rank.getMatchReward() + "원)";
        String winningCountString = "- " + lottoResult.winningCount(rank) + "개";
        return countString + rewordString + winningCountString;
    }
}
