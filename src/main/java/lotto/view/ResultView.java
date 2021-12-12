package lotto.view;

import lotto.domain.Lotto;

public class ResultView {
    public void printLottoCount(int lottoPieceCount) {
        System.out.println(lottoPieceCount + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printMatchingStatistics() {
        System.out.println("당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)- 1개");
        System.out.println("총 수익률은 0.35입니다.");
    }

}
