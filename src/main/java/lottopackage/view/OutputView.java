package lottopackage.view;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.Prize;

import java.util.*;

public class OutputView {

    /* Method */
    public static void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "장을 구매했습니다.");
    }

    public static void printLottoGroup(List<Lotto> lottoGroup) {
        for (int i = 0; i < lottoGroup.size(); i++) {
            printLotto(lottoGroup.get(i));
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.print("[");
        Iterator<LottoBall> iteratorLotto = lotto.getLotto().iterator();
        int lottoSize = lotto.getLotto().size();
        for (int i = 0; i < lotto.getLotto().size(); i++) {
            String delimiter = (i == (lottoSize - 1)) ? "" : ", ";
            System.out.print(iteratorLotto.next().getLottoBall() + delimiter);
        }
        System.out.println("]");
    }

    public static void printLottoResult(List<Prize> lottoResult, int totalLottoGroupSize) {
        List<Prize> prizeGroup = Arrays.asList(Prize.values());
        int totalWinningAmount = 0;

        System.out.println("당첨 통계");
        System.out.println("--------");

        for (int i = 0; i < prizeGroup.size(); i++) {
            Prize prize = prizeGroup.get(i);
            System.out.println(prize.getBall() + "개 일치 ("
                    + prize.getWinningAmount() + "원)- "
                    + Collections.frequency(lottoResult, prize) + "개");
            totalWinningAmount += (prize.getWinningAmount()) * (Collections.frequency(lottoResult, prize));
        }

        System.out.println("총 수익률은" + (float) totalWinningAmount / (totalLottoGroupSize * 1000) + "입니다.");
    }
}
