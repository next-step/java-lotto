package step2;

import step2.domain.UserLotto;
import step2.generator.LottoGenerator;

import java.util.List;

public class LottoGame {

  public static final int LOTTO_PRICE = 1000;
  private List<UserLotto> userLottoList;
  private final int amount;
  private final int count;

  public LottoGame(int amount) {
    this.amount = amount;
    this.count = amount / LOTTO_PRICE;
    this.userLottoList = LottoGenerator.generateList(this.count);
  }

  public int getCount() {
    return this.count;
  }

  public List<UserLotto> getUserLottoList() {
    return this.userLottoList;
  }

}
