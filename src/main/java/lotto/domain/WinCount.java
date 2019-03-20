package lotto.domain;

public class WinCount {

  private long count = 0;

  public WinCount increment() {
    count++;
    return this;
  }

  public long count() {
    return count;
  }
}
