package lotto.domain.game;

public enum LottoGameType {
  MANUAL("수동"), AUTO("자동");

  private final String name;

  LottoGameType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
