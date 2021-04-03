package step2.domain.number;

import step2.exception.DuplicatedLottoNumber;
import step2.exception.InvalidNumbersSizeException;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
  private final List<LottoNumber> lottoNumbers;

  private static final int STANDARD_SIZE = 6;
  private static final String SIZE_ERROR_MESSAGE = "숫자 개수가 일치하지 않습니다.";
  private static final String DUPLICATED_ERROR_MESSAGE = "중복된 숫자가 있습니다.";

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }

    if(lottoNumbers.stream().distinct().count() != STANDARD_SIZE){
      throw new DuplicatedLottoNumber(DUPLICATED_ERROR_MESSAGE);
    }

    this.lottoNumbers = lottoNumbers;
  }

  public void sort() {
    Collections.sort(lottoNumbers);
  }

  public LottoMatchingNumber matchNumbers(LottoNumbers targetLottoNumbers) {
//    int result = targetLottoNumbers.lottoNumbers.stream().filter(lottoNumbers::contains).mapToInt(e -> 1).sum();
    int result = 0;
    for(LottoNumber targetLottoNumber : targetLottoNumbers.lottoNumbers) {
      result += containingCheck(targetLottoNumber);
    }
    return new LottoMatchingNumber(result);
  }

  private int containingCheck(LottoNumber targetLottoNumber){
    if(lottoNumbers.contains(targetLottoNumber)){
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
