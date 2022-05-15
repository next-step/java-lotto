package lotto.view;

import lotto.domain.*;

public class ResultView {

    public void printLottos(Draw draw) {
        System.out.println(draw.lottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : draw.lottos()) {
            printLotto(lotto);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    void printLotto(Lotto lotto) {
        int size = lotto.lottoNumbers().size();
        int i = 1;

        System.out.print("[");
        for (LottoNumber lottoNumber : lotto.lottoNumbers()) {
            System.out.print(lottoNumber.number());
            printComma(i++, size);
        }
        System.out.print("]");
    }

    void printComma(int i, int size) {
        if (i != size) {
            System.out.print(", ");
        }
    }

    public void printWinningsLotto(Winnings winnings) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Matched[] matcheds = Matched.values();
        for (int i = 4; i >= 0; i--) {
            System.out.print(matcheds[i].numberOfMatched() + "개 일치");
            printBonus(i);
            System.out.print(" (" + matcheds[i].reward() + "원) - ");
            System.out.println(winnings.recordMatched()[i] + "개");
        }
    }

    private void printBonus(int index) {
        if (index == Matched.FIVE_AND_BONUS.index()) {
            System.out.print(", 보너스 볼 일치");
        }
    }

    public void printEarningsRatio(double result) {
        System.out.print("총 수익률은 " + String.format("%.2f", result) + "입니다.");
        printResult(result);
    }

    private void printResult(double result) {
        if (result < 1) {
            System.out.println("(손해)");
            return ;
        }
        if (result == 1) {
            System.out.println("(본전)");
            return ;
        }
        if (result > 1) {
            System.out.println("(이득)");
        }
    }
}
