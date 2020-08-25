package kr.heesu.lotto.controller;

import kr.heesu.lotto.domain.*;
import kr.heesu.lotto.utils.LottoFactory;
import kr.heesu.lotto.view.ViewResolver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final ViewResolver viewResolver;

    private LottoController(ViewResolver viewResolver) {
        this.viewResolver = viewResolver;
    }

    public static LottoController of() {
        return new LottoController(ViewResolver.of());
    }

    public void main() {
        try {
            String stringAmount = viewResolver.getPurchaseAmount();
            PurchaseAmount amount = makePurchaseAmountFromUserInput(stringAmount);

            viewResolver.printPurchaseAmount(amount);

            Lottos multipleLotto = LottoFactory.createLottosAutomatic(amount);
            viewResolver.printMultipleLotto(multipleLotto);

            String stringWinningNumbers = viewResolver.getWinningNumbers();
            WinningNumbers winningNumbers = makeWinningNumbersFromUserInput(stringWinningNumbers);

            String stringBonusNumber = viewResolver.getBonusNumbers();
            LottoNumber bonusNumber = makeLottoNumber(stringBonusNumber);

            RankResult matches = multipleLotto.matches(winningNumbers, bonusNumber);

            LottoStatistics statistics = makeLottoStatistics(matches, amount);

            viewResolver.printLottoStatistics(statistics);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private LottoNumber makeLottoNumber(String stringBonusNumber) {
        return LottoNumber.of(Integer.parseInt(stringBonusNumber));
    }

    private LottoStatistics makeLottoStatistics(RankResult matches, PurchaseAmount amount) {
        return LottoStatistics.of(matches, amount);
    }

    private WinningNumbers makeWinningNumbersFromUserInput(String input) {
        List<LottoNumber> numbers = Stream.of(input.split(", "))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return WinningNumbers.of(numbers);
    }

    private PurchaseAmount makePurchaseAmountFromUserInput(String input) {
        return PurchaseAmount.of(Integer.parseInt(input));
    }
}
