package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    public static void main(String[] args) {


        int money = InputView.purchase();
        List<Lotto> lottos = Lotto.puchase(money);
        ResultView.purchase(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.bonusNumber());
        Result result = new Result(lottos, winningNumbers, bonusNumber);
        ResultView.result(result, money);
    }
}
