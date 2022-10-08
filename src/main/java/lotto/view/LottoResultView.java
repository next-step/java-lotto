package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankRecord;

public class LottoResultView {

    private LottoResultView() {

    }

    public static void printBuyLottoNumber(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print("[");
            List<Integer> numbers = lotto.retrieveNumbers();
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.print(numbers.get(i) + ", ");
            }
            System.out.println(numbers.get(numbers.size() - 1) + "]");
        }
        System.out.println();
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

    public static void printProfitRatio(float ratio) {
        System.out.println("총 수익률은 " + String.format("%.2f", ratio) + "입니다.");
    }
}
