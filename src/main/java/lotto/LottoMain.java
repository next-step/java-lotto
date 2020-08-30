package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

import static lotto.view.InputView.getLottoPrice;
import static lotto.view.InputView.getWinningNumbers;
import static lotto.view.ResultView.*;

public class LottoMain {
    public static void main(String[] args) {
        /* 로또 가격 입력 및 로또 장수 출력 */
        int paidMoney = getLottoPrice();
        Lottos lottos = Lottos.of(paidMoney);
        printLottoCount(lottos.getLottos().size());

        /* 랜덤 생성 로또 번호 출력 */
        printLottoNumber(lottos.getLottos());

        /* 지난 주 당첨 번호 입출력 */
        WinningNumbers winningNumbers= new WinningNumbers(getWinningNumbers());
        printWinningCount(lottos.getWinningCount(winningNumbers), paidMoney);

    }


}
