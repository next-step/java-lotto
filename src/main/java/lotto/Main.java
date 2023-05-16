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

        // 로또 생성
        List<Lotto> lottoList = buyManyOfLotto(buyCount);

        // 지난주 당첨 번호 생성
        String stringNumbers = LottoInputView.askLastWinnerNumbers();
        WinnerNumbers winnerNumbers = makeWinnerNumbers(stringNumbers);

        // 로또 당첨 결과 확인
        LottoResults lottoResults = makeLottoResults(winnerNumbers, lottoList, money);
        LottoOutputView.printLottoResults(lottoResults);
    }

    private static List<Lotto> buyManyOfLotto(int buyCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottoList.add(lotto);
            LottoOutputView.printLotto(lotto);
        }
        return lottoList;
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
