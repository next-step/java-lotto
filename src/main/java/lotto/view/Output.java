package lotto.view;

import lotto.domain.*;
import lotto.strategy.AutoNumberList;

import java.math.BigDecimal;
import java.util.List;

public class Output {

    private static final String OUTPUT_UNIT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public static List<Lotto> print(List<Lotto> manualLottoNumberList, int manualLottoCount, BigDecimal amount) {
        Lottos lottos = new Lottos(amount);
        int numberOfTickets = lottos.getNumberOfTickets(amount);
        int autoTickets = numberOfTickets - manualLottoCount;
        System.out.println(String.format(OUTPUT_UNIT_MESSAGE, manualLottoCount, autoTickets));

        Lottos numberList = lottos.buyLottos(manualLottoNumberList, autoTickets, new AutoNumberList());
        List<Lotto> lottoList = numberList.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumberList());
        }
        System.out.println();

        return lottoList;
    }

    public static List<Lotto> getRank(List<Lotto> lottoList, List<Integer> winnerNumberList, Integer bonusBallNumber) {

        boolean hasBonusNumber = matchNumber(lottoList, bonusBallNumber);

        int[] matchList = new int[6 + 1];
        for (Lotto lotto : lottoList) {
            Lotto matchRank = lotto.matchRank(winnerNumberList, hasBonusNumber);
            matchList[matchRank.match()]++;
        }

        System.out.println("당첨 통계");
        System.out.println("---------");

        match(Rank.FIFTH.getCount(), Rank.FIFTH.getAmount(), matchList[Rank.FIFTH.getCount()]);
        match(Rank.FORTH.getCount(), Rank.FORTH.getAmount(), matchList[Rank.FORTH.getCount()]);

        // Rank.SECOND.getCount == 5, Rank.THIRD.getCount == 5
        if (Lottos.getRank(lottoList)) {
            match(Rank.THIRD.getCount(), Rank.THIRD.getAmount(), 0);
            matchBonusBall(Rank.SECOND.getCount(), Rank.SECOND.getAmount(), matchList[Rank.SECOND.getCount()]);
        }

        if (!Lottos.getRank(lottoList)) {
            match(Rank.THIRD.getCount(), Rank.THIRD.getAmount(), matchList[Rank.THIRD.getCount()]);
            matchBonusBall(Rank.SECOND.getCount(), Rank.SECOND.getAmount(), 0);
        }

        match(Rank.FIRST.getCount(), Rank.FIRST.getAmount(), matchList[Rank.FIRST.getCount()]);

        return lottoList;
    }

    private static boolean matchNumber(List<Lotto> lottoList, Integer number) {
        for (int i = 0; i < lottoList.size(); i++) {

            List<LottoNumber> lottolist = lottoList.get(i).getNumberList();
            for (int j = 0; j < lottolist.size(); j++) {

                int matchNumber = lottolist.get(j).getNumber();
                if (matchNumber == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void match(int count, BigDecimal amount, int number) {
        System.out.printf(String.format("%d개 일치 (%.0f원)- %d개\n", count, amount, number));
    }

    private static void matchBonusBall(int count, BigDecimal amount, int number) {
        System.out.printf(String.format("%d개 일치, 보너스 볼 일치(%.0f원)- %d개\n", count, amount, number));
    }

    public static void getResult(List<Lotto> lottoList) {
        BigDecimal statics = LottoStatics.calculate(lottoList);
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", statics));
    }
}
