package lotto.domain.model;

public enum Trilean {
  TRUE, FALSE, IRRELEVANCE;

  public boolean matches(boolean bool) {
    switch (this) {
      case TRUE:
        return bool;

      case FALSE:
        return !bool;

      case IRRELEVANCE:
        return true;
    }

    throw new IllegalArgumentException("Invalid Trilean value");
  }
}
