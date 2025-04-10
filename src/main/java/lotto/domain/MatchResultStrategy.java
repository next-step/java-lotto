package lotto.domain;

public class MatchResultStrategy implements MatchStrategy {

  private final int matchCount;
  private final boolean requiresBonusBall;

  public MatchResultStrategy(int matchCount, boolean requiresBonusBall) {
    this.matchCount = matchCount;
    this.requiresBonusBall = requiresBonusBall;
  }

  @Override
  public boolean matches(int matchCount, boolean hasBonusBall) {
    if (requiresBonusBall) {
      return matchCount == this.matchCount && hasBonusBall;
    }
    return matchCount == this.matchCount;
  }

  @Override
  public int getMatchCount() {
    return matchCount;
  }

  @Override
  public boolean requiresBonusBall() {
    return requiresBonusBall;
  }
} 