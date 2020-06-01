package lotto.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeTierMapper {
  INSTANCE;

  private final Map<Integer, PrizeTier> mapper;

  PrizeTierMapper() {
    this.mapper = Stream.of(PrizeTier.values())
        .collect(Collectors.toMap(PrizeTier::getMatchCnt, prizeTier -> prizeTier));
  }

  /**
   * 맞춘 개수에 따라 PrizeTier 반환
   *
   * @param matchCnt 맞춘 개수
   * @return 맞춘 개수가 3 미만일 경우 MATCH_ZERO 반환
   */
  public PrizeTier getPrizeTierByMatchCnt(int matchCnt) {
    if (matchCnt < PrizeTier.MATCH_THREE.getMatchCnt()) {
      matchCnt = PrizeTier.MATCH_ZERO.getMatchCnt();
    }

    return mapper.get(matchCnt);
  }
}
