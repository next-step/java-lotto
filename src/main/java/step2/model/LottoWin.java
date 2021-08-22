package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {

  private Map<Integer, Integer> winnerCountMap;

  private List<String> lottoWinningNumbers;
  private int lottoWinningBonusNumber;

  public LottoWin(String[] lottoWinningNumbers) {
    winnerCountMap = new HashMap() {{
      put(WinnerMoney.FIRST_WINNER_MONEY.winRank, 0);
      put(WinnerMoney.SECOND_WINNER_MONEY.winRank, 0);
      put(WinnerMoney.THIRD_WINNER_MONEY.winRank, 0);
      put(WinnerMoney.FOURTH_WINNER_MONEY.winRank, 0);
      put(WinnerMoney.FIFTH_WINNER_MONEY.winRank, 0);
    }};

    this.lottoWinningNumbers = new ArrayList(Arrays.asList(lottoWinningNumbers));
  }

  public LottoWin(String[] lottoWinningNumbers, int lottowinningBonusNumber) {
    this(lottoWinningNumbers);
    this.lottoWinningBonusNumber = lottowinningBonusNumber;
  }

  private int isMatchNumber(Lotto lotto, String lottoNumStr) {
    int matchNumberCount = 0;
    if (lotto.getLottoNumbers().contains(Integer.parseInt(lottoNumStr))) {
      matchNumberCount = 1;
    }
    return matchNumberCount;
  }

  public void addWinnerCount(WinnerMoney winnerMoney, boolean hasWinningBonusNumber) {
    if (hasWinningBonusNumber) {
      winnerCountMap.replace(WinnerMoney.SECOND_WINNER_MONEY.getWinRank(),
          winnerCountMap.get(winnerMoney.getWinRank()) + 1);
    } else {
      winnerCountMap
          .replace(winnerMoney.getWinRank(), winnerCountMap.get(winnerMoney.getWinRank()) + 1);
    }
  }

  public int getWinnerCount(int winnerRank) {
    return winnerCountMap.get(winnerRank);
  }

  public LottoWin draw(Lottos lottos) {
    for (int i = 0; i < lottos.getLottosSize(); i++) {
      calculateRank(lottos.getLotto(i));
    }

    return this;
  }

  private void calculateRank(Lotto lotto) {
    int matchNumberCount = 0;
    boolean hasWinningBonusNumber = false;

    for (String lottoNumStr : lottoWinningNumbers) {
      matchNumberCount += isMatchNumber(lotto, lottoNumStr);
    }

    if (isMatchNumber(lotto, String.valueOf(lottoWinningBonusNumber)) == 1) {
      hasWinningBonusNumber = true;
    }

    calculateWin(matchNumberCount, hasWinningBonusNumber);
  }

  private void calculateWin(int matchNumberCount, boolean hasWinningBonusNumber) {
    if (matchNumberCount <= 0) {
      return;
    }

    for (WinnerMoney winnerMoney : WinnerMoney.values()) {
      matchWinnerCount(matchNumberCount, winnerMoney, hasWinningBonusNumber);
    }
  }

  private boolean matchWinnerCount(int matchNumberCount, WinnerMoney winnerMoney,
      boolean hasWinningBonusNumber) {
    if (matchNumberCount == winnerMoney.getMatchNumberCount()
        && hasWinningBonusNumber == winnerMoney.hasMatchBonusNumber()) {
      addWinnerCount(winnerMoney, hasWinningBonusNumber);
      return true;
    }

    return false;
  }
}
