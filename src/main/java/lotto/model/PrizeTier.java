package lotto.model;

import java.util.stream.Stream;

public enum PrizeTier {
  MATCH_SIX(2000000000, new MatchCnt(6, false)),
  MATCH_FIVE_WITH_BONUS(30000000, new MatchCnt(5, true)),
  MATCH_FIVE(1500000, new MatchCnt(5, false)),
  MATCH_FOUR(50000, new MatchCnt(4, false)),
  MATCH_THREE(5000, new MatchCnt(3, false)),
  MATCH_TWO(0, new MatchCnt(2, false)),
  MATCH_ONE(0, new MatchCnt(1, false)),
  MATCH_ZERO(0, new MatchCnt(0, false));

  private final long prize;
  private final MatchCnt matchCnt;

  PrizeTier(long prize, MatchCnt matchCnt) {
    this.prize = prize;
    this.matchCnt = matchCnt;
  }

  public long getPrize() {
    return prize;
  }

  public MatchCnt getMatchCnt() {
    return matchCnt;
  }

  public static PrizeTier valueOf(MatchCnt matchCnt) {
    return Stream.of(PrizeTier.values())
        .filter(prizeTier -> prizeTier.getMatchCnt().equals(matchCnt))
        .findAny()
        .orElse(null);
  }
}
