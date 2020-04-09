package lotto.domain.model;

public enum Trilean {
  TRUE, FALSE, IRRELEVANCE;

  public boolean matches(boolean bool) {
    if (this == TRUE)
        return bool;

    if (this == FALSE)
        return !bool;

    if (this == IRRELEVANCE)
        return true;

    throw new IllegalArgumentException("Invalid Trilean value");
  }
}
