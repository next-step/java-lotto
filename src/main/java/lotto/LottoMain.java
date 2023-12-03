package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;


    public static void main(String[] args) {
        Result result = new Result();

        int money = InputView.purchase();
        List<Lotto> lottos = puchase(money);
        ResultView.purchase(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        lottos.forEach(l -> {
            int count = l.matchCount(winningNumbers);
            result.update(count);
        });
        ResultView.result(result, money);
    }

    public static List<Lotto> puchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; ++i) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
        return lottos;
    }
}
