package lotto.service;

import static lotto.service.Operation.MULTIPLE;
import static lotto.service.Operation.chooseOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.WinLottoInfo;

public class LotteryDraw {

  private static final String SPLIT_MARK = ",";

  private final LottoMoney lottoMoney;

  public LotteryDraw(final LottoMoney lottoMoney) {
    this.lottoMoney = lottoMoney;
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return new Lotto(splitWinningNumbers(removeBlankValue(winningLottery)));
  }

  private String removeBlankValue(final String winningLottery) {
    return winningLottery.replace(" ", "");
  }

  private List<Integer> splitWinningNumbers(final String winningLottery) {
    return Arrays.stream(winningLottery.trim().split(SPLIT_MARK))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public double gradingScore(LottoResult lottoResult) {
    return lottoMoney.getReward(lottoResult.getCategoriesRank().keySet()
        .stream()
        .mapToInt(rank -> getCalculation(lottoResult.getRankCount(rank),
            rank.getWinningMoney())).sum());
  }

  private int getCalculation(final int matchCount, final int winningMoney) {
    return chooseOperation(MULTIPLE).calculation(matchCount, winningMoney);
  }

  public WinLottoInfo createWinLottoInfo(String winningLottery, int bonusNumber) {
    return new WinLottoInfo(inputWinningNumbers(winningLottery), bonusNumber);
  }

}