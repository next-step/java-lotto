package lotto;

public class LottoNo implements Comparable<LottoNo>{

  private final Integer lottoNumber;

  public LottoNo(Integer lottoNumber) {
    if (!valid(lottoNumber)) {
      throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야합니다.");
    }
    this.lottoNumber = lottoNumber;
  }

  private boolean valid(Integer lottoNumber) {
    return 1 <= lottoNumber && lottoNumber <= 45;
  }

  public boolean has(BonusBall bonusBall) {
    return bonusBall.equals(lottoNumber);
  }

  public boolean has(WinningNumbers winningNumbers) {
    return winningNumbers.has(lottoNumber);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public int compareTo(LottoNo input) {
    return this.lottoNumber.compareTo(input.lottoNumber);
  }
}
