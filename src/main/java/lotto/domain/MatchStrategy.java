package lotto.domain;

public interface MatchStrategy {

  boolean matches(int matchCount, boolean hasBonusBall);

  int getMatchCount();

  boolean requiresBonusBall();
} 