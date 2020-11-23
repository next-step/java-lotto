package lotto;

import lotto.domain.*;
import lotto.dto.LottoGameResultDto;
import lotto.utils.Calculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
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
            Rank rank = winningNumber.getRank(lottoNumber);
            ranks.add(rank);
        }

        LottoGameResult lottoGameResult = new LottoGameResult(ranks);

        LottoGameResultDto firstCount = lottoGameResult.getRankCount(Rank.FIRST);
        LottoGameResultDto secondCount = lottoGameResult.getRankCount(Rank.SECOND);
        LottoGameResultDto thirdCount = lottoGameResult.getRankCount(Rank.THIRD);
        LottoGameResultDto fourthCount = lottoGameResult.getRankCount(Rank.FOURTH);

        ResultView.printLottoGameResult(Arrays.asList(fourthCount, thirdCount, secondCount, firstCount));

        int prizeMoney = ranks.stream()
                .mapToInt(Rank::getPrizeMoney)
                .sum();

        double rate = Calculator.calculateRateOfReturn(lottoAmount.getAmount(), prizeMoney);

        ResultView.printWinningStatistics(rate);


    }
}
