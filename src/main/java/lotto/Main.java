package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int buyPriceAmount = InputView.inputBuyAmount();
        List<Lotto> lottosBought = LottoStore.buy(buyPriceAmount);
        OutputView.printBuyLottoCount(lottosBought.size());
        OutputView.printLottos(lottosBought);
        OutputView.printNewLine();

        final String winningNumber = InputView.inputWinningNumber();
        final int bonus = InputView.inputBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(winningNumber, bonus);
        OutputView.printNewLine();

        printWinningLottoResult(lottosBought, winningLotto, buyPriceAmount);
    }

    private static void printWinningLottoResult(List<Lotto> lottosBought,
                                                WinningLotto winningLotto,
                                                long buyPriceAmount) {
        OutputView.printWinningLottoTitle();
        OutputView.printDashBar();

        for(LottoRank lottoRank : getLottoRanksSortAscContainWinningNumber()) {
            OutputView.printSameCountWinningNumber(lottoRank,
                    LottoCheck.getWinningLottoCount(lottosBought, winningLotto, lottoRank),
                    lottoRank.isBonus());
        }

        OutputView.printReturnValue(LottoCheck.getTotalWinningAmount(lottosBought, winningLotto),
                BigDecimal.valueOf(buyPriceAmount));
    }

    private static List<LottoRank> getLottoRanksSortAscContainWinningNumber() {
       return  LottoRank.getWinningLotto().stream().sorted(new Comparator<LottoRank>() {
            @Override
            public int compare(LottoRank o1, LottoRank o2) {
                return o1.getContainCountsSameWinningNumber() - o2.getContainCountsSameWinningNumber();
            }
        }).collect(Collectors.toList());
    }
}
