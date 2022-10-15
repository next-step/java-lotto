package lotto.view;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoInput;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankRecord;
import lotto.domain.LottoRankRecordBox;

public class LottoResultView {

    private static final String LOTTO_DELIMITER = ", ";
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private LottoResultView() {
    }

    public static void printLottoInput(LottoInput lottoInput) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.%n", lottoInput.getManualCount(), lottoInput.getAutoCount());
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            STRING_BUILDER
                    .append("[")
                    .append(makeLottoNumberLine(lotto))
                    .append("]\n");
        }
        System.out.println(STRING_BUILDER);
        clearStringBuilder();
    }

    private static void clearStringBuilder() {
        STRING_BUILDER.delete(0, STRING_BUILDER.length());
    }

    private static String makeLottoNumberLine(Lotto lotto) {
        Set<LottoBall> numbers = lotto.retrieveNumbers();
        return numbers.stream()
                .map(LottoBall::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER));
    }

    public static void printWinStatistics(LottoRankRecordBox lottoRankRecordBox) {
        STRING_BUILDER.append("\n당첨 통계\n--------");
        for (LottoRankRecord lottoRankRecord : lottoRankRecordBox.getLottoRankRecords()) {
            stringBuildRankRecord(lottoRankRecord);
        }
        STRING_BUILDER.append("\n");
        System.out.println(STRING_BUILDER);
        clearStringBuilder();
    }

    private static void stringBuildRankRecord(LottoRankRecord lottoRankRecord) {
        if (lottoRankRecord.isNotRank(LottoRank.NONE)) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            STRING_BUILDER.append("\n");
            STRING_BUILDER.append(String.format("%s개 일치", rank.getCorrectCount()));
            addBonusWinMessage(rank);
            STRING_BUILDER.append(String.format(" (%s원)- %s개", rank.getWinPrize(), number));
        }
    }

    private static void addBonusWinMessage(LottoRank rank) {
        if (LottoRank.BONUS.equals(rank)) {
            STRING_BUILDER.append(", 보너스 볼 일치");
        }
    }

    public static void printProfitRatio(double ratio) {
        System.out.println("총 수익률은 " + String.format("%.2f", ratio) + "입니다.");
    }
}
