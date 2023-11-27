package lotto;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();
    private static final int PRINT_MATCHES_LIMIT = 3;

    public static void printLottoList(LottoList lottoList, int manualLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                manualLottoCount, lottoList.size() - manualLottoCount);
        for (Lotto lotto : lottoList) {
            printLottoList(lotto);
        }
    }

    private static void printLottoList(Lotto lotto) {
        sb.setLength(0);
        sb.append("[");

        for (LottoNumber lottoNumber : lotto) {
            sb.append(lottoNumber.lottoNumber());
            sb.append(", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append("]");

        System.out.println(sb);
    }

    public static void printResult(LottoResult lottoResult) {
        OutputView.printResultPhrase();
        OutputView.printMatchesResults(lottoResult.lottoMatchResult());
        OutputView.printRateOfReturn(lottoResult.rateOfReturn());
    }

    private static void printResultPhrase() {
        System.out.println("당첨 통계");
        System.out.println("---------------");
    }

    private static void printMatchesResults(LottoMatchResult lottoMatchResult) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            printMatchesResult(lottoMatch, lottoMatchResult);
        }
    }

    private static void printMatchesResult(LottoMatch lottoMatch, LottoMatchResult lottoMatchResult) {
        if (lottoMatch.matchCount() < PRINT_MATCHES_LIMIT) {
            return;
        }

        LottoMatch.Match match = LottoMatch.Match.from(lottoMatch.matchCount(), lottoMatch.isBonus());
        int count = lottoMatch.matchesCount(match, lottoMatchResult);

        if(match == LottoMatch.Match.FIVE_WITH_BONUS) {
            printBonusLottoMatch(lottoMatch, count);
            return;
        }

        printLottoMatch(lottoMatch, count);
    }

    private static void printBonusLottoMatch(LottoMatch lottoMatch, int count) {
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n",
                lottoMatch.matchCount(), lottoMatch.amount(), count);
    }

    private static void printLottoMatch(LottoMatch lottoMatch, int count) {
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                lottoMatch.matchCount(), lottoMatch.amount(), count);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%s 입니다.", rateOfReturn, "%");
    }
}
