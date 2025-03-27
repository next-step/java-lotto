package lotto;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<LottoRow> lottoRowList) {
        for (LottoRow lottoRow : lottoRowList) {
            System.out.println(lottoRow.getLottoNumbers());
        }
    }

    public static void printWinning(Map<Prize, Integer> winning) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i <= 6; i++) {
            Prize prize = Prize.valueOfCount(i);
            Integer count = winning.getOrDefault(prize, 0);
            System.out.println(i + "개 일치 (" + prize.getMoney() + ")- " + count + "개" );
        }
    }
}
