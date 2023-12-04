package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
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
            Optional<Rank> rank = l.rank(winningNumbers);
            rank.ifPresent(result::update);
        });
        ResultView.result(result, money);
    }
}
