package lotto.view;

import lotto.domain.Draw;
import lotto.domain.Lotto;
import lotto.domain.Winnings;

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
        int size = lotto.selectedNumbers().size();
        int i = 1;

        System.out.print("[");
        for (int number : lotto.selectedNumbers()) {
            System.out.print(number);
            printComma(i++, size);
        }
        System.out.print("]");
    }

    void printComma(int i, int size) {
        if (i != size) {
            System.out.print(", ");
        }
    }

    public void checkWinningsLotto(Winnings winnings) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i < winnings.recordMatched().length; i++) {
            System.out.println(i + "개 일치 (" + winnings.rewards()[i] + "원) - "
                    + winnings.recordMatched()[i] + "개");
        }
    }
}
