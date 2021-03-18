package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class LottoList {

  private List<Lotto> lottoList;
  private static final String DUPLICATED_LOTTO = "중복된 로또는 발급할 수 없습니다.";

  public LottoList(List<Lotto> lottoList) {
    validateDuplicated(lottoList);
    this.lottoList = lottoList;
  }

  public void validateDuplicated(List<Lotto> lottoList) {
    boolean isNotDuplicated = lottoList.stream()
        .allMatch(new HashSet<>()::add);

    if (!isNotDuplicated) {
      throw new IllegalArgumentException(DUPLICATED_LOTTO);
    }
  }

  public LottoStatistics makeMatchingCount(LastWinningLotto lastWeekWinningLotto) {
    LottoStatistics lottoStatistics = new LottoStatistics();
    for (Lotto lotto : lottoList) {
      int matchingCount = lotto.containsCount(lastWeekWinningLotto);
      boolean matchBouns = lotto.matchBonusBall(lastWeekWinningLotto);
      LottoRank rank = LottoRank.findByMatchingCount(matchingCount, matchBouns);
      lottoStatistics.put(rank);
    }
    return lottoStatistics;
  }

  public int getLottoCount() {
    return lottoList.size();
  }

  public List<Lotto> getLottoList() {
    return lottoList;
  }
}
