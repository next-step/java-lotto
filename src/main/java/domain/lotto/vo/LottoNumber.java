package domain.lotto.vo;

public class LottoNumber {
  private Integer number;

  public LottoNumber(Integer number) {
    validateNumber(number);
    this.number = number;
  }

  public Integer getNumber() {
    return number;
  }

  private void validateNumber(int number) {
    if(number < 1 || number > 45) {
      throw new IllegalArgumentException("로또 번호는 1부터 45까지 가능합니다.");
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) obj;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }
}
