package lotto;

import lotto.domain.*;
import lotto.utils.Calculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MainSimulator {
    public static void main(String[] args) {

        LottoAmount lottoAmount = new LottoAmount(InputView.enterLottoAmount());

        List<LottoNumbers> lottoNumbers = LottoNumberGenerator.create(lottoAmount.getLottoCount());
        ResultView.printLottoNumbers(lottoNumbers);

        String winningNumbers = InputView.enterWinningNumbers();

        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        List<Rank> ranks = new ArrayList<>();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            Rank rank = winningNumber.getRank(lottoNumber.getValue());
            ranks.add(rank);
        }

        TreeMap<Integer, List<Rank>> collect = ranks.stream()
                .collect(Collectors.groupingBy(Rank::getMatchingNumberCount, TreeMap::new, Collectors.toList()));

        int prizeMoney = ranks.stream().mapToInt(Rank::getPrizeMoney).sum();

        double rate = Calculator.calculateRateOfReturn(lottoAmount.getAmount(), prizeMoney);

        ResultView.printWinningStatistics(collect, rate);


    }
}
