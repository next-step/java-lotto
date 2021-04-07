package step4.domain;

import step2.exception.InvalidLottoNumberException;
import step4.domain.number.Count;
import step4.domain.number.LottoNumber;
import step4.domain.result.LottoMatchingResult;
import step4.domain.result.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private static final String DUPLICATED_BONUS_BALL_MESSAGE = "보너스 볼은 기존 추첨된 공과 중복되지 못합니다.";

  private final List<Lotto> lottos;

  public Lottos() {
    lottos = new ArrayList<>();
  }

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public void addLotto(Lotto lotto) {
    lottos.add(lotto);
  }

  public Count quantity() {
    return new Count(lottos.size());
  }

  public Lottos mergeLottos(Lottos otherLottos) {
    List<Lotto> sourceLottos = new ArrayList<>(lottos);
    sourceLottos.addAll(otherLottos.lottos);

    return new Lottos(sourceLottos);
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottos) {
      sb.append(lotto.toString()).append(System.lineSeparator());
    }
    return sb.toString();
  }
}
