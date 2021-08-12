package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.WinLottoInfo;

public class LotteryDraw {

  private static final String SPLIT_MARK = ",";

  public static Lotto inputWinningNumbers(String winningLottery) {
    return new Lotto(splitWinningNumbers(removeBlankValue(winningLottery)));
  }

  private static String removeBlankValue(final String winningLottery) {
    return winningLottery.replace(" ", "");
  }

  private static List<Integer> splitWinningNumbers(final String winningLottery) {
    return Arrays.stream(winningLottery.trim().split(SPLIT_MARK))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public static double gradingScore(LottoResult lottoResult,
      final LottoMoney lottoMoney) {
    return LottoMoney.getReward(lottoResult.allRankResultSum(), lottoMoney);
  }

  public static WinLottoInfo createWinLottoInfo(String winningLottery, int bonusNumber) {
    return new WinLottoInfo(inputWinningNumbers(winningLottery), bonusNumber);
  }

}