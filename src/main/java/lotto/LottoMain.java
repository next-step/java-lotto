package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        Result result = new Result();

        int money = InputView.purchase();
        List<Lotto> lottos = Lotto.puchase(money);
        ResultView.purchase(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        lottos.forEach(l -> {
            int count = l.matchCount(winningNumbers);
            result.update(count);
        });
        ResultView.result(result, money);
    }
}
