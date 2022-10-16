package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.RankMap;
import lotto.generator.ManualNumberGenerator;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Lottos lottos = new Lottos(inputPurchaseNumber());
        printPurchaseNumber(lottos.lottosSize());
        printLottoNumbers(lottos);

        Lotto lotto = new Lotto(new ManualNumberGenerator(inputWinningNumber()));
        LottoNumber bonus = LottoNumber.from(inputBonusBall());
        RankMap rankMap = lottos.getResult(lotto, bonus);
        printWinningResult(rankMap);
        printProfitRate(rankMap, lottos.lottosSize());
    }
}
