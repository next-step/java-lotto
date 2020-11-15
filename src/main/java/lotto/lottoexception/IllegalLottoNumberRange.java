package lotto.lottoexception;

public class IllegalLottoNumberRange extends IllegalArgumentException{
  public IllegalLottoNumberRange(){
    super("허용되지 않는 범위의 로또 번호입니다.");
  }
}
