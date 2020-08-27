package lotto;

import lotto.domain.Lotto;
import lotto.view.ResultView;

import static lotto.view.InputView.getLottoPrice;
import static lotto.view.ResultView.printLottoCount;

public class LottoMain {
    public static void main(String[] args) {
        /* 로또 가격 입력 및 로또 장수 출력 */
        int lottoPrice = getLottoPrice();
        Lotto lotto = new Lotto(lottoPrice);
        printLottoCount(lotto.getLottoCount());

    }


}
