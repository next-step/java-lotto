package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int amount = LottoInputView.askBuyAmount();
        Money money = new Money(amount);
        int buyCount = money.buyCount(Lotto.PRICE);
        LottoOutputView.printBuyCount(buyCount);

        List<Lotto> lottos = buyLottos(buyCount);

        String stringNumbers = LottoInputView.askLastWinnerNumbers();
        WinnerNumbers winnerNumbers = makeWinnerNumbers(stringNumbers);

        LottoResults lottoResults = makeLottoResults(winnerNumbers, lottos, money);
        LottoOutputView.printLottoResults(lottoResults);
    }

    private static List<Lotto> buyLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
            LottoOutputView.printLotto(lotto);
        }
        return lottos;
    }

    private static WinnerNumbers makeWinnerNumbers(String stringNumbers) {
        Set<LottoNumber> lottoNumbers = LottoNumbersParser.parseToSet(stringNumbers);
        return new WinnerNumbers(lottoNumbers);
    }

    private static LottoResults makeLottoResults(WinnerNumbers winnerNumbers, List<Lotto> lottoList, Money money) {
        Map<Rank, Integer> winningStats = LottoMatcher.match(winnerNumbers, lottoList);
        return new LottoResults(money, winningStats);
    }
}
