package lotto;

import lotto.domain.Lottos;

import static lotto.view.InputView.getLottoPrice;
import static lotto.view.InputView.getWinningNumbers;
import static lotto.view.ResultView.*;

public class LottoMain {
    public static void main(String[] args) {
        /* 로또 가격 입력 및 로또 장수 출력 */
        int lottoPrice = getLottoPrice();
        Lottos lottos = Lottos.of(lottoPrice);
        printLottoCount(lottos.getLottoCount());

        /* 랜덤 생성 로또 번호 출력 */
        printLottoNumber(lottos.getLottoList());

        /* 지난 주 당첨 번호 입출력 */
        printWinningCount(lottos.getWinningCount(getWinningNumbers()), lottoPrice);

    }


}
