package step2.domain.result;

import step2.domain.Number;
import step2.enums.Rank;
import step2.domain.UserLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
  private final Map<Rank, Long> matchResultMap;
  private final double earningRate;

  public LottoResult(List<UserLotto> userLottoList, int lottoPrice, Number bonusNo) {
    this.matchResultMap = initMatchResultMap(userLottoList, bonusNo.get());
    this.earningRate = initEarningRate(lottoPrice);
  }

  private Map<Rank, Long> initMatchResultMap(List<UserLotto> userLottoList, int bonusNo) {
    return userLottoList.stream()
          .collect(Collectors.groupingBy(userLotto -> Rank.of(userLotto.getMatchCount(), userLotto.hasBonusNo(bonusNo)),
              HashMap::new,
              Collectors.counting())
          );
  }

  private double initEarningRate(double lottoPrice) {
    return this.matchResultMap.keySet().stream()
        .mapToInt(rank -> (int) (rank.getReward() * this.getMatchResultMap().get(rank)))
        .sum() / lottoPrice;
  }

  public Map<Rank, Long> getMatchResultMap() {
    return this.matchResultMap;
  }

  public double getEarningRate() {
    return this.earningRate;
  }

}
