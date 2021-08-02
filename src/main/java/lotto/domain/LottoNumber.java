package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber>{

  private int number;

  public LottoNumber(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    return checkGreaterThanInputValue(lottoNumber);
  }

  private int checkGreaterThanInputValue(LottoNumber lottoNumber) {
    if(this.number < lottoNumber.getNumber()){
      return -1;
    }
    return checkLessThanInputValue(lottoNumber);
  }

  private int checkLessThanInputValue(LottoNumber lottoNumber) {
    if(this.number < lottoNumber.getNumber()){
      return 1;
    }
    return 0;
  }
}
