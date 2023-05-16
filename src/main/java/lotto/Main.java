package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int amount = LottoInputView.askBuyAmount();
        Money money = new Money(amount);

        List<Lotto> lottos = LottoShop.buyLottos(money);
        LottoOutputView.printBuyCount(lottos.size());
        LottoOutputView.printLottos(lottos);

        String stringNumbers = LottoInputView.askLastWinnerNumbers();
        WinnerNumbers winnerNumbers = makeWinnerNumbers(stringNumbers);

        LottoResults lottoResults = makeLottoResults(winnerNumbers, lottos, money);
        LottoOutputView.printLottoResults(lottoResults);
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
