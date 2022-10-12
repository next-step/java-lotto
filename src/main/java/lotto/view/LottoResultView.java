package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankRecord;

public class LottoResultView {

    private static final String LOTTO_DELIMITER = ", ";

    private LottoResultView() {

    }

    public static void printBuyLottoNumber(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb
                    .append("[")
                    .append(makeLottoNumberLine(lotto))
                    .append("]\n");
        }
        System.out.println(sb);
    }

    private static String makeLottoNumberLine(Lotto lotto) {
        List<Integer> numbers = lotto.retrieveNumbers();
        String lottoLine = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return lottoLine;
    }

    public static void printWinStatistics(List<LottoRankRecord> rankRecords) {
        System.out.println("\n당첨 통계\n--------");
        for (LottoRankRecord lottoRankRecord : rankRecords) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            System.out.println(
                    rank.getCorrectNum() + "개 일치 " + "(" + rank.getWinPrize() + ")" + "- " + number
                            + "개");
        }
    }

    public static void printProfitRatio(double ratio) {
        System.out.println("총 수익률은 " + String.format("%.2f", ratio) + "입니다.");
    }
}
