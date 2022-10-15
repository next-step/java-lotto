package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankRecord;

public class LottoResultView {

    private static final String LOTTO_DELIMITER = ", ";
    private static final StringBuilder sb = new StringBuilder();

    private LottoResultView() {

    }

    public static void printBuyLottoNumber(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            sb
                    .append("[")
                    .append(makeLottoNumberLine(lotto))
                    .append("]\n");
        }
        System.out.println(sb);
        clearStringBuilder();
    }

    private static void clearStringBuilder() {
        sb.delete(0, sb.length());
    }

    private static String makeLottoNumberLine(Lotto lotto) {
        List<Integer> numbers = lotto.retrieveNumbers();
        String lottoLine = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return lottoLine;
    }

    public static void printWinStatistics(List<LottoRankRecord> rankRecords) {
        sb.append("\n당첨 통계\n--------");
        for (LottoRankRecord lottoRankRecord : rankRecords) {
            stringBuildRankRecord(lottoRankRecord);
        }
        sb.append("\n");
        System.out.println(sb);
        clearStringBuilder();
    }

    private static void stringBuildRankRecord(LottoRankRecord lottoRankRecord) {
        if (lottoRankRecord.isNotRank(LottoRank.NONE)) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            sb.append("\n");
            sb.append(rank.getCorrectCount()).append("개 일치");
            addBonusWinMessage(rank);
            sb.append(" (").append(rank.getWinPrize()).append("원)- ").append(number).append("개");
        }
    }

    private static void addBonusWinMessage(LottoRank rank) {
        if (LottoRank.BONUS.equals(rank)) {
            sb.append(", 보너스 볼 일치");
        }
    }

    public static void printProfitRatio(double ratio) {
        System.out.println("총 수익률은 " + String.format("%.2f", ratio) + "입니다.");
    }
}
