package lotto.executor;

import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoExecutor {


    public static void main(String[] args) {

        int lottoTotalPrice = InputView.getNumberInput("구입금액을 입력해 주세요.");
        int lottoCount = Lottos.getLottoCount(lottoTotalPrice);

        ResultView.printView(lottoCount + "개를 구매했습니다.");
        Lottos lottos = Lottos.createLottos(lottoCount, new RandomLottoNumberStrategy());
        ResultView.printLottoNumberView(lottos);

        ResultView.printView("\n");

        String winningString = InputView.getInput("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumList = InputView.getNumberListFromString(winningString);


    }
}
