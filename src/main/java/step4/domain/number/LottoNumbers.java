package step4.domain.number;

import step4.exception.DuplicatedLottoNumberException;
import step4.exception.InvalidNumbersSizeException;
import step4.exception.InvalidSplitStringException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
  private static final int ZERO = 0;
  private static final int STANDARD_SIZE = 6;
  private static final String SIZE_ERROR_MESSAGE = "숫자 개수가 일치하지 않습니다.";
  private static final String DUPLICATED_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
  private static final String COLON_MATCHER = ",";
  private static final String SPLIT_ERROR_MESSAGE = "분해할 수 없는 문자열입니다. 문자열: ";

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(String expression){
    lottoNumbers = split(expression);
  }

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }

    if (distinctSize(lottoNumbers) != STANDARD_SIZE) {
      throw new DuplicatedLottoNumberException(DUPLICATED_ERROR_MESSAGE);
    }

    this.lottoNumbers = lottoNumbers;
    Collections.sort(lottoNumbers);
  }

  private Long distinctSize(List<LottoNumber> lottoNumbers) {
    return lottoNumbers.stream().distinct().count();
  }

  public Count matchNumbers(LottoNumbers targetLottoNumbers) {
    int result = targetLottoNumbers
      .lottoNumbers
      .stream()
      .filter(lottoNumbers::contains)
      .mapToInt(e -> 1)
      .sum();

    return new Count(result);
  }

  public boolean matchSpecificNumber(LottoNumber targetLottoNumber) {
    boolean result = false;
    if (lottoNumbers.contains(targetLottoNumber)) {
      result = true;
    }
    return result;
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }

  private List<LottoNumber> split(String expression){
    String[] tokens = divideParameter(expression);
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String token : tokens) {
      lottoNumbers.add(splitOneToken(token));
    }
    return lottoNumbers;
  }

  public static LottoNumbers convertStringToLottoNumbers(String lottoParameter) {
    String[] tokens = divideParameter(lottoParameter);
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String token : tokens) {
      lottoNumbers.add(splitOneToken(token));
    }
    return new LottoNumbers(lottoNumbers);
  }

  private static String[] divideParameter(String lottoParameter) {
    if (lottoParameter == null || lottoParameter.trim().isEmpty()) {
      throw new InvalidSplitStringException(SPLIT_ERROR_MESSAGE + lottoParameter);
    }

    String[] tokens = lottoParameter.split(COLON_MATCHER);
    if (tokens.length != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }
    return tokens;
  }

  private static LottoNumber splitOneToken(String token) {
    int number = ZERO;
    try {
      number = Integer.parseInt(token);
    } catch (NumberFormatException numberFormatException) {
      throw new InvalidSplitStringException(SPLIT_ERROR_MESSAGE + token);
    }
    return new LottoNumber(number);
  }


}
