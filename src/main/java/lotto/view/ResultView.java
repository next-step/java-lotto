package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import javax.xml.transform.Result;

public class ResultView {
    public static void printCostOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumbersOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void printWinningNumber() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> ResultView.printLotto(lotto));
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
