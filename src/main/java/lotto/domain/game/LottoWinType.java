package lotto.domain.game;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWinType {

  RANK_4(3, 5_000),
  RANK_3(4, 50_000),
  RANK_2(5, 1_500_000),
  RANK_1(6, 2_000_000_000);

  private final int matchingNumberCnt;
  private final int prize;

  LottoWinType(int matchingNumberCnt, int prize) {
    this.matchingNumberCnt = matchingNumberCnt;
    this.prize = prize;
  }

  private static final Map<Integer, LottoWinType> matchingCntMap = Collections.unmodifiableMap(
      Stream.of(LottoWinType.values())
          .collect(Collectors.toMap(LottoWinType::getMatchingNumberCnt, Function.identity()))
  );

  public static LottoWinType findByMatchingNumberCnt(int matchingNumberCnt) {
    return matchingCntMap.get(matchingNumberCnt);
  }

  public int getMatchingNumberCnt() {
    return matchingNumberCnt;
  }

  public int getPrize() {
    return prize;
  }
}
