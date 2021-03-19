package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;

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
                (key, matchCount) -> System.out.println(count(key) + matchCount + "")
        );
    }

    private String count(Integer key) {
        if (key == 3) {
            return "3개 일치 (5000원) - ";
        }

        if (key == 4) {
            return "4개 일치 (50000원) - ";
        }

        if (key == 5) {
            return "5개 일치 (150000원) - ";
        }

        if (key == 6) {
            return "6개 일치 (20000000원) - ";
        }

        return "";
    }

    public void printBenefit(Lottos lottos) {
        System.out.println("총 수익률은 " + lottos.totalBenefit() + "입니다.");
    }

}
