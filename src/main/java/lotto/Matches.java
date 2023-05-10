package lotto;

public enum Matches {

  MATCH_THREE(3, 5000L) {
    @Override
    void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtThreeMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getThreeMatches();
    }
  },
  MATCH_FOUR(4, 50000L) {
    @Override
    void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtFourMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getFourMatches();
    }
  },
  MATCH_FIVE(5, 1500000L) {
    @Override
    void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtFiveMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getFiveMatches();
    }
  },
  MATCH_SIX(6, 2000000000L) {
    @Override
    void addCount(MatchesStatus matchesStatus) {
      matchesStatus.addOneAtSixMatches();
    }

    @Override
    public int getCount(MatchesStatus matchesStatus) {
      return matchesStatus.getSixMatches();
    }
  };

  private final int numberOfMatches;
  private final long winningAmount;

  abstract void addCount(MatchesStatus matchesStatus);
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
    for (Matches matches: Matches.values()) {
      if (matches.isMatches(numberOfMatches)) {
        return matches;
      }
    }
    return null;
  }

}
