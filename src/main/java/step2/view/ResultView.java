package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinnerPriceType;

public class ResultView {

    public void printPurchase(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "를 구매했습니다.");
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumber());
    }

    public void printSameLotto(Lottos lottos, String lastWinning) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottos.matchLotto(lastWinning).forEach(
                (matchNumber, matchCount) ->
                        System.out.println(matchNumber + "개 일치 (" + WinnerPriceType.of(matchNumber).winningAmount + ")- "+ matchCount +"개")
        );
        System.out.println("총 수익률은 " + lottos.totalBenefit());

    }
}
