package lotto.domain;

public enum MatchLotto {
  FOURTH(3, 5000, "4등"),
  THIRD(4, 50000, "3등"),
  SECOND(5, 1500000, "2등"),
  FIRST(6, 2000000000, "1등");

  private int matchResult;
  private int prize;
  private String winner;

  MatchLotto(int matchResult, int prize, String winner) {
    this.matchResult = matchResult;
    this.prize = prize;
    this.winner = winner;
  }

  public MatchLotto valueOf(int matchResult) {
    MatchLotto matches = null;
    for (MatchLotto matchLotto : MatchLotto.values()) {
      matches = matches(matchResult, matchLotto);
    }
    return matches;
  }

  private MatchLotto matches(int matchResult, MatchLotto matchLotto) {
    if (matchLotto.matchResult == matchResult) {
      return matchLotto;
    }
    throw new IllegalArgumentException("허용되지 않은 값이 입력되었습니다.");
  }
}
