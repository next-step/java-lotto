package lotto.domain;

public enum OrderType {

  MANUAL("수동"),
  AUTO("자동");

  private final String displayName;

  OrderType(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
