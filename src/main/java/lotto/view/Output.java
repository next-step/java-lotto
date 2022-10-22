package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatics;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;

public class Output {

    private static final String OUTPUT_UNIT_MESSAGE = "개를 구매했습니다.";

    public static List<Lotto> print(BigDecimal amount) {
        Lottos lottos = new Lottos(amount);
        int NumberOfTickets = lottos.getNumberOfTickets(amount);
        System.out.println(NumberOfTickets + OUTPUT_UNIT_MESSAGE);

        Lottos numberList = lottos.buyLottos(NumberOfTickets);
        List<Lotto> lottoList = numberList.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumberList());
        }
        System.out.println();

        return lottoList;
    }

    public static List<Lotto> getRank(List<Lotto> lottoList, List<Integer> winnerNumberList) {

        int[] matchList = new int[5 + 1];
        for (Lotto lotto : lottoList) {
            Lotto matchRank = lotto.matchRank(winnerNumberList);
            matchList[matchRank.match()]++;
        }

        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i <= 5; i++) {
            match(i, Rank.getRank(i).getAmount(), matchList[i]);
        }

        return lottoList;
    }

    private static void match(int count, BigDecimal amount, int number) {
        System.out.printf(String.format("%d개 일치 (%.2f원)- %d개\n", count, amount, number));
    }

    public static void getResult(List<Lotto> lottoList) {
        BigDecimal statics = LottoStatics.calculate(lottoList);
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", statics));
    }
}
