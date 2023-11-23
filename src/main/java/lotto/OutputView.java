package lotto;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();
    private static final int PRINT_MATCHES_LIMIT = 3;

    public static void printLotto(LottoList lottoList) {
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
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

    public static void printResultPhrase() {
        System.out.println("당첨 통계");
        System.out.println("---------------");
    }

    public static void printMatchesResults(LottoMatchResult lottoMatchResult) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            printMatchesResult(lottoMatch, lottoMatchResult);
        }
    }

    private static void printMatchesResult(LottoMatch lottoMatch, LottoMatchResult lottoMatchResult) {
        if (lottoMatch.matchCount() < PRINT_MATCHES_LIMIT) {
            return;
        }

        if(lottoMatch == LottoMatch.FIVE_BONUS) {
            printBonusLottoMatch(lottoMatch);
            return;
        }

        printLottoMatch(lottoMatch);
    }

    private static void printBonusLottoMatch(LottoMatch lottoMatch) {
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n",
                lottoMatch.matchCount(), lottoMatch.amount(), lottoMatch.matchCount());
    }

    private static void printLottoMatch(LottoMatch lottoMatch) {
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                lottoMatch.matchCount(), lottoMatch.amount(), lottoMatch.matchCount());
    }

    public static void printRateOfReturn(LottoResult lottoResult,
                                         LottoWinningNumbers lottoWinningNumbers) {
        double rateOfReturn = lottoResult.rateOfReturn(lottoWinningNumbers);
        System.out.printf("총 수익률은 %.1f%s 입니다.", rateOfReturn, "%");
    }
}
