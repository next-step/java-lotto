package model.winning;

import java.util.Arrays;

public enum Matches {

  MATCH_THREE(3, 5000L) {
    @Override
    protected void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtThreeMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getThreeMatches();
    }
  },
  MATCH_FOUR(4, 50000L) {
    @Override
    protected void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtFourMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getFourMatches();
    }
  },
  MATCH_FIVE(5, 1500000L) {
    @Override
    protected void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtFiveMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getFiveMatches();
    }
  },
  MATCH_FIVE_AND_BONUS(5, 30000000L) {
    @Override
    protected void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtFiveAndBonusMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getFiveAndBonusMatches();
    }
  },
  MATCH_SIX(6, 2000000000L) {
    @Override
    protected void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtSixMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getSixMatches();
    }
  };

  private final int numberOfMatches;
  private final long winningAmount;

  abstract protected void addCount(MatchesStatus matchesStatus);

  abstract public int getCount(MatchesStatus matchesStatus);

  Matches(int numberOfMatches, long winningAmount) {
    this.numberOfMatches = numberOfMatches;
    this.winningAmount = winningAmount;
  }

  public int getNumberOfMatches() {
    return numberOfMatches;
  }

  public long getWinningAmount() {
    return winningAmount;
  }

  private boolean isMatches(int number) {
    return this.numberOfMatches == number;
  }

  public static Matches getMatches(int numberOfMatches) {
    return Arrays.stream(Matches.values())
        .filter(matches -> matches.isMatches(numberOfMatches))
        .findFirst()
        .orElse(null);
  }

}
