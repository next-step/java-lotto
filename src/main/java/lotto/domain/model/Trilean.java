package lotto.domain.model;

public enum Trilean {
  TRUE, FALSE, IRRELAVANT;

  public boolean matches(boolean bool) {
    switch (this) {
      case TRUE:
        return bool;

      case FALSE:
        return !bool;

      case IRRELAVANT:
        return true;
    }
    return bool;
  }
}
