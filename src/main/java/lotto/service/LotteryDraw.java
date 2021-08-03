package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.RealGenerateLottoNumber;

public class LotteryDraw {

  private int money;

  private Lotties lotties;

  public static final String SPLIT_MARK = ",";

  public static final int EACH_LOTTO_COST = 1000;

  public static final int START = 1;

  public static final int END = 46;

  GenerateLottoNumber generateLottoNumber = new RealGenerateLottoNumber(START, END);

  public LotteryDraw(int money) {
    this.money = money;
  }

  public LotteryDraw() {

  }

  public void checkInputValue() {
    if (Operation.chooseOperation("%").calculation(money, EACH_LOTTO_COST) != 0) {
      throw new RuntimeException("금액을 정상적으로 입력해주세요.");
    }
  }

  public int getNumberOfLotto() {
    return Operation.chooseOperation("/").calculation(money, EACH_LOTTO_COST);
  }

  public void buyLotties() {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto(), generateLottoNumber);
  }

  public void buyLotties(GenerateLottoNumber generateLottoNumber) {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto(), generateLottoNumber);
  }

  public Lotties getLottiesInfo() {
    return lotties;
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return Lotties.getWinningLotto(winningLottery.trim().split(SPLIT_MARK));
  }

  public List<Integer> matchLottoInfo(Lotties lotties, Lotto winLotto) {
    List<Integer> totalGames = new ArrayList<>();

    for (Lotto lotty : lotties.getLotties()) {
      int count = 0;
      totalGames.add(Operation.chooseOperation("+")
          .calculation(count, lotties.getMatchLotties(lotty, winLotto)));
    }
    return totalGames;
  }
}
