package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.RankMap;
import lotto.generator.ManualNumberGenerator;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int autoLottoCnt = inputAutoPurchaseNumber();
        Lottos lottos = new Lottos(autoLottoCnt);

        List<Lotto> lottoList = lottos.getLottoList();
        int manualLottoCnt = inputManualPurchaseNumber();
        List<String> manualLottoNumber = inputManualLottoNumber(manualLottoCnt);
        for (int i = 0; i < manualLottoCnt; i++) {
            lottoList.add(new Lotto(new ManualNumberGenerator(manualLottoNumber.get(i))));
        }

        printLottoNumbers(lottos);
        printPurchaseNumber(lottos.lottosSize());

        String winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusBall();
        Lotto lotto = new Lotto(new ManualNumberGenerator(winningNumber));
        LottoNumber bonus = LottoNumber.from(bonusNumber);
        RankMap rankMap = lottos.getResult(lotto, bonus);
        printWinningResult(rankMap);
        printProfitRate(rankMap, lottos.lottosSize());
    }
}
