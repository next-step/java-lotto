package step2.view;

import step2.domain.Lotto;

public class ResultView {
    public void displayLotto(Lotto lotto) {
        System.out.println(lotto.displayLottoNumber());
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public void displayWinningStatistics() {
        System.out.println(String.format("%d 개 일치(%d원)- %d개",1,2,3));
    }
}
