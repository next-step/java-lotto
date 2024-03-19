package domain;

public enum Currency {
  KRW("원");

  private final String unit;

  Currency(final String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return this.unit;
  }
}
