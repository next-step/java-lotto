package lotto.domain;

public final class LottoTryCount {

  private final int manualTryCount;
  private final int autoTryCount;

  public LottoTryCount(final int manualTryCount, final int autoTryCount) {
    this.manualTryCount = manualTryCount;
    this.autoTryCount = autoTryCount;
  }

  public int getManualTryCount() {
    return manualTryCount;
  }

  public int getAutoTryCount() {
    return autoTryCount;
  }
}
