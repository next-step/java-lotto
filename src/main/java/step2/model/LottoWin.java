package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {

  private Map<WinnerMoney, Integer> winnerCountMap;

  private List<String> lottoWinningNumbers;
  private int lottoWinningBonusNumber;

  private LottoWin(String[] lottoWinningNumbers) {
    winnerCountMap = new HashMap();
    this.lottoWinningNumbers = new ArrayList(Arrays.asList(lottoWinningNumbers));
  }

  public LottoWin(String[] lottoWinningNumbers, int lottowinningBonusNumber) {
    this(lottoWinningNumbers);
    this.lottoWinningBonusNumber = lottowinningBonusNumber;
  }

  private boolean isMatchNumber(Lotto lotto, String lottoNumStr) {
    return lotto.getLottoNumbers().contains(Integer.parseInt(lottoNumStr));
  }

  public void addWinnerCount(WinnerMoney winnerMoney, boolean hasWinningBonusNumber) {
    WinnerMoney winnerMoneyKey = winnerMoney;
    if (hasWinningBonusNumber) {
      winnerMoneyKey = WinnerMoney.SECOND_WINNER_MONEY;
    }

    winnerCountMap.replace(winnerMoneyKey, winnerCountMap.get(winnerMoney) + 1);
  }

  public int getWinnerCount(WinnerMoney winnerMoney) {
    return winnerCountMap.get(winnerMoney);
  }

  public LottoWin draw(Lottos lottos) {
    initWinnerCount();
    for (int i = 0; i < lottos.getLottosSize(); i++) {
      calculateRank(lottos.getLotto(i));
    }

    return this;
  }

  private void initWinnerCount() {
    for (WinnerMoney winnerMoney : WinnerMoney.values()) {
      winnerCountMap.put(winnerMoney, 0);
    }
  }

  private void calculateRank(Lotto lotto) {
    int matchNumberCount = 0;
    boolean hasWinningBonusNumber = false;

    for (String lottoNumStr : lottoWinningNumbers) {
      matchNumberCount = addMatchNumberCount(lotto, matchNumberCount, lottoNumStr);
    }

    if (isMatchNumber(lotto, String.valueOf(lottoWinningBonusNumber))) {
      hasWinningBonusNumber = true;
    }

    calculateWin(matchNumberCount, hasWinningBonusNumber);
  }

  private int addMatchNumberCount(Lotto lotto, int matchNumberCount, String lottoNumStr) {
    if (isMatchNumber(lotto, lottoNumStr)) {
      matchNumberCount++;
    }
    return matchNumberCount;
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
    if (isWinnerCondition(matchNumberCount, winnerMoney, hasWinningBonusNumber)) {
      addWinnerCount(winnerMoney, hasWinningBonusNumber);
      return true;
    }

    return false;
  }

  private boolean isWinnerCondition(int matchNumberCount, WinnerMoney winnerMoney,
      boolean hasWinningBonusNumber) {
    return matchNumberCount == winnerMoney.getMatchNumberCount()
        && hasWinningBonusNumber == winnerMoney.hasMatchBonusNumber();
  }
}
