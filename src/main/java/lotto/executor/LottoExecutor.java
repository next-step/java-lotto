package lotto.executor;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoExecutor {


    public static void main(String[] args) {

        int lottoTotalPrice = InputView.getNumberInput("구입금액을 입력해 주세요.");
        int lottoCount = Lottos.getLottoCount(lottoTotalPrice);
        ResultView.printView(lottoCount + "개를 구매했습니다.");

//        Lottos lottos = getLottoList(lottoCount);


    }
}
