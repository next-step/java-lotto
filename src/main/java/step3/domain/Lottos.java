package step3.domain;

import step2.exception.InvalidLottoNumberException;
import step3.domain.number.Count;
import step3.domain.number.LottoNumber;
import step3.domain.result.LottoMatchingResult;
import step3.domain.result.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private static final String DUPLICATED_BONUS_BALL_MESSAGE = "보너스 볼은 기존 추첨된 공과 중복되지 못합니다.";

  private final List<Lotto> lottos;

  public Lottos() {
    lottos = new ArrayList<>();
  }

  public void addLotto(Lotto lotto) {
    lottos.add(lotto);
  }

  public Count quantity() {
    return new Count(lottos.size());
  }

  public LottoMatchingResult matchLottosWithBonusBall(Lotto prizeLotto, LottoNumber bonusNumber) {
    if (prizeLotto.matchSpecificBall(bonusNumber)) {
      throw new InvalidLottoNumberException(DUPLICATED_BONUS_BALL_MESSAGE);
    }
    LottoMatchingResult lottoMatchingResult = new LottoMatchingResult();
    for (Lotto targetLotto : lottos) {
      int matchingCount = targetLotto.matchLotto(prizeLotto).showCount();
      Boolean bonusFlag = targetLotto.matchSpecificBall(bonusNumber);

      lottoMatchingResult.add(Rank.findRankByCountOfMatch(matchingCount, bonusFlag));
    }
    return lottoMatchingResult;
  }

  /*
   * 이 부분을 지웠음에도 남기는 이유
   * 기존 로또들만 가지고 체크하는 로직을 완전 수정해야 하는지,
   * 혹은 추가된 부분만 추가하고자 할 지 고민을 했을 때 가장
   *
  public LottoMatchingResult matchLottos(Lotto prizeLotto) {
    LottoMatchingResult lottoMatchingResult = new LottoMatchingResult();
    for (Lotto targetLotto : lottos) {
      lottoMatchingResult.add(targetLotto.matchLotto(prizeLotto));
    }

    return lottoMatchingResult;
  }
   */


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottos) {
      sb.append(lotto.toString()).append(System.lineSeparator());
    }
    return sb.toString();
  }
}
