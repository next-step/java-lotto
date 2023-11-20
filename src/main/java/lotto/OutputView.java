package lotto;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void printLottoList(LottoList lottoList) {
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

    public static void printResultPhrase() {
        System.out.println("당첨 통계");
        System.out.println("---------------");
    }

    public static void printMatchesResult(LottoMatchResult lottoMatchResult) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if (lottoMatch.matchCount() < 4) {
                continue;
            }
            int count = LottoMatch.matchesCount(lottoMatch.matchCount(), lottoMatchResult);
            System.out.printf("%d개 일치 (%d원) - %d개\n",
                lottoMatch.matchCount(), lottoMatch.amount(), count);
        }
    }

    public static void printRateOfReturn(LottoResult lottoResult,
                                         LottoWinningNumbers lottoWinningNumbers) {
        System.out.printf("총 수익률은 %.1f%s 입니다.", lottoResult.rateOfReturn(lottoWinningNumbers), "%");
    }
}
