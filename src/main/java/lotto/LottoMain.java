package lotto;

import lotto.domain.Lottos;
import lotto.view.ResultView;

import static lotto.view.InputView.getLottoPrice;
import static lotto.view.ResultView.printLottoCount;

public class LottoMain {
    public static void main(String[] args) {
        /* 로또 가격 입력 및 로또 장수 출력 */
        int lottoPrice = getLottoPrice();
        Lottos lottos = Lottos.of(lottoPrice);
        printLottoCount(lottos.getLottoCount());

    }


}
