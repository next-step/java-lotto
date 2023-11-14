package lotto;

import lotto.controller.LottoInput;
import lotto.model.Lotto;
import lotto.view.LottoOutput;

import java.util.List;

import static lotto.model.LottoFactory.*;
import static lotto.util.LottoUtil.*;

public class simulator {
    public static void main(String[] args) {
        int purchaseAmount = LottoInput.getInput();
        int lottoCnt = getLottoCount(purchaseAmount);
        LottoOutput.viewLottoCount(lottoCnt);
        List<Lotto> lottos = generateLotto(lottoCnt);
        LottoOutput.viewLottoDetail(lottos);
    }
}
