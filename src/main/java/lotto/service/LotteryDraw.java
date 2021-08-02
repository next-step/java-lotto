package lotto.service;

import lotto.domain.Lotties;
import lotto.domain.Lotto;

public class LotteryDraw {

  private int money;

  private Lotties lotties;

  private Lotto wininLotto;

  public static final int EACH_LOTTO_COST = 1000;

  public LotteryDraw(int money) {
    this.money = money;
  }

  public LotteryDraw() {

  }

  public void checkInputValue() {
    if (Operation.chooseOperation("%").calculation(money,EACH_LOTTO_COST) != 0) {
      throw new RuntimeException("금액을 정상적으로 입력해주세요.");
    }
  }

  public int getNumberOfLotto() {
    return Operation.chooseOperation("/").calculation(money,EACH_LOTTO_COST);
  }

  public void buyLotties() {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto());
  }

  public Lotties getLottiesInfo() {
    return lotties;
  }

  public Lotto inputWinningNumbers(String winningLottery) {

    checkWinningLottery();
    String[] winScoreArray= winningLottery.trim().split(",");
    return new Lotto(winScoreArray);
  }

  private void checkWinningLottery() {

  }
}
