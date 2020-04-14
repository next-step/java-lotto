package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.ui.InputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        List<Lotto> lottos = LottoSeller.buyLottos(money);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        Lotto winningLotto = Lotto.ofComma(winningLottoNumbers);


    }
}
