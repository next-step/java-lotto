package step3.util;

import step3.domain.number.LottoNumber;
import step3.exception.InvalidSplitStringException;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
  private static final String COLON_MATCHER = ",";
  private static final String ERROR_MESSAGE = "분해할 수 없는 문자열입니다. 문자열: ";

  private Splitter() {
  }

  public static List<LottoNumber> split(String expression) {

    if (expression == null || expression.trim().isEmpty()) {
      throw new InvalidSplitStringException(ERROR_MESSAGE + expression);
    }

    if (expression.trim().length() == 1) {
      return splitOneObject(expression);
    }

    return splitNumbers(expression);
  }

  private static List<LottoNumber> splitOneObject(String expression) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    int number = 0;
    try {
      number = Integer.parseInt(expression);
    } catch (Exception e) {
      throw new InvalidSplitStringException(ERROR_MESSAGE + expression);
    }
    lottoNumbers.add(new LottoNumber(number));
    return lottoNumbers;
  }

  private static List<LottoNumber> splitNumbers(String expression) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    String[] tokens = customPatternMatcher(expression);
    for (String token : tokens) {
      lottoNumbers.addAll(splitOneObject(token.trim()));
    }
    return lottoNumbers;
  }

  private static String[] customPatternMatcher(String expression) {
    String[] tokens;
    tokens = expression.split(COLON_MATCHER);
    return tokens;
  }

}
