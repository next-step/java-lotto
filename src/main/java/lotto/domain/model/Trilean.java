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

    throw new IllegalArgumentException("유효하지 않은 Trilean(three valued boolean) 값입니다.");
  }
}
