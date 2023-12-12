package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        int money = InputView.purchase();
        int totalCount = money / Lotto.LOTTO_PRICE;
        int countOfManual = InputView.countOfManual();
        List<String> manualLottos = InputView.purchaseManual(countOfManual);
        lottos.addAll(Lotto.puchaseManual(manualLottos));
        lottos.addAll(Lotto.puchaseAuto(totalCount - countOfManual));
        ResultView.purchase(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.bonusNumber());
        Result result = new Result(lottos, winningNumbers, bonusNumber);
        ResultView.result(result, money);
    }
}
