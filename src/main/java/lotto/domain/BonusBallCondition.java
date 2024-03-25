package lotto.domain;

public enum BonusBallCondition {
  TRUE,
  FALSE,
  DONT_CARE;

  public Boolean isBonusBallConditionMatched(final Boolean isBonusBallMatched) {
    if (this == BonusBallCondition.DONT_CARE) {
      return true;
    }

    if (this == BonusBallCondition.TRUE) {
      return isBonusBallMatched;
    }

    return !isBonusBallMatched;
  }

  public Boolean needMatch() {
    return this == TRUE;
  }
}

