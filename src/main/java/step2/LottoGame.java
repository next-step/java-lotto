package step2;

import step2.domain.Number;
import step2.domain.result.LottoResult;
import step2.domain.UserLotto;
import step2.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

  private final List<UserLotto> userLottoList;
  private final int amount;
  private final int count;
  private final WinningLotto winningLotto;
  private final Number bonusNo;

  public LottoGame(int amount, int count, List<List<Integer>> userLottoList, String winningLotto, String bonusNo) {
    this.amount = amount;
    this.count = count;
    this.winningLotto = new WinningLotto(winningLotto);
    this.userLottoList = initUserLottoList(userLottoList);
    this.bonusNo = new Number(bonusNo);
  }

  public LottoResult start() {
    return new LottoResult(userLottoList, amount, bonusNo);
  }

  private List<UserLotto> initUserLottoList(List<List<Integer>> userLottoList) {
    List<UserLotto> result = new ArrayList<>();
    for (List<Integer> userLotto : userLottoList) {
      result.add(initUserLotto(userLotto));
    }
    return result;
  }

  private UserLotto initUserLotto(List<Integer> userLotto) {
    List<Number> numbers = userLotto.stream()
        .map(Number::new)
        .collect(Collectors.toList());
    return new UserLotto(numbers, winningLotto);
  }

  public List<UserLotto> getUserLottoList() {
    return this.userLottoList;
  }

}
