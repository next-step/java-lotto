package lotto.auto;

import lotto.auto.domain.Lotto;
import lotto.auto.domain.LottoHandler;
import lotto.auto.domain.Win;
import lotto.auto.view.InputView;
import lotto.auto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoHandler lottoHandler = new LottoHandler();

        String money = inputView.inputView("구입금액을 입력해 주세요.");
        int lottoCount = lottoHandler.buyLotto(money);
        outputView.print(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = lottoHandler.createLotto(lottoCount);
        for (Lotto lotto : lottos) {
            outputView.print(lotto.toString());
        }
        String winNumberString = inputView.inputView("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = lottoHandler.compareWinNumbers(winNumberString);
        List<Win> wins = lottoHandler.confirmWinner(lottos, winNumbers);
        Double returnPercent = lottoHandler.getReturn(money, wins);
        outputView.print("당첨 통계");
        outputView.print("---------");
        outputView.print(Win.LAST_PLACE.getMatchNumber() + "개 일치 (" + Win.LAST_PLACE.getReward() + "원)-" + Collections.frequency(wins, Win.LAST_PLACE) + "개");
        outputView.print(Win.THIRD_PLACE.getMatchNumber() + "개 일치 (" + Win.THIRD_PLACE.getReward() + "원)-" + Collections.frequency(wins, Win.THIRD_PLACE) + "개");
        outputView.print(Win.SECOND_PLACE.getMatchNumber() + "개 일치 (" + Win.SECOND_PLACE.getReward() + "원)-" + Collections.frequency(wins, Win.SECOND_PLACE) + "개");
        outputView.print(Win.FIRST_PLACE.getMatchNumber() + "개 일치 (" + Win.FIRST_PLACE.getReward() + "원)-" + Collections.frequency(wins, Win.FIRST_PLACE) + "개");
        outputView.print("총 수익률은 " + returnPercent + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

    }
}
