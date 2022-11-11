package lotto.view;

import lotto.domain.*;
import lotto.strategy.AutoNumberList;

import java.math.BigDecimal;
import java.util.List;

public class Output {

    private static final String OUTPUT_UNIT_MESSAGE = "개를 구매했습니다.";

    public static List<Lotto> print(BigDecimal amount) {
        Lottos lottos = new Lottos(amount);
        int NumberOfTickets = lottos.getNumberOfTickets(amount);
        System.out.println(NumberOfTickets + OUTPUT_UNIT_MESSAGE);

        Lottos numberList = lottos.buyLottos(NumberOfTickets, new AutoNumberList());
        List<Lotto> lottoList = numberList.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumberList());
        }
        System.out.println();

        return lottoList;
    }

    public static List<Lotto> getRank(List<Lotto> lottoList, List<Integer> winnerNumberList, Integer bonusBallNumber) {

        boolean hasBonusNumber = matchNumber(lottoList, bonusBallNumber);
        Integer bonusBall = getTrueOrFalse(hasBonusNumber);

        int[] matchList = new int[6 + 1];
        for (Lotto lotto : lottoList) {
            Lotto matchRank = lotto.matchRank(winnerNumberList, hasBonusNumber);
            matchList[matchRank.match()]++;
        }

        System.out.println("당첨 통계");
        System.out.println("---------");

        match(3, Rank.FIFTH.getAmount(), matchList[3]);
        match(4, Rank.FORTH.getAmount(), matchList[4]);

        if (Lottos.getRank(lottoList)) {
            match(5, Rank.THIRD.getAmount(), 0);
            matchBonusBall(5, Rank.SECOND.getAmount(), matchList[5]);
        }

        if (!Lottos.getRank(lottoList)) {
            match(5, Rank.THIRD.getAmount(), matchList[5]);
            matchBonusBall(5, Rank.SECOND.getAmount(), 0);
        }

        match(6, Rank.FIRST.getAmount(), matchList[6]);

        return lottoList;
    }

    private static Integer getTrueOrFalse(boolean hasBonusNumber) {
        Integer bonusBall = 0;
        if (!hasBonusNumber) {
            bonusBall = 1;
        }
        return bonusBall;
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
