package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;

public class WinningLotto {

  private static final String WINNING_LOTTO_BASED_SPLIT_REGEX = ", ";
  private static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> winningLottoNumbers;

  public WinningLotto(List<LottoNumber> winningLottoNumbers) {
    validateDuplicateNumber(winningLottoNumbers);
    this.winningLottoNumbers = winningLottoNumbers;
  }

  private void validateDuplicateNumber(List<LottoNumber> winningLottoNumbers) {
    Set<Integer> validateLottoNumbers = new HashSet<>();
    for (LottoNumber winningLottoNumber : winningLottoNumbers) {
      validateLottoNumbers.add(winningLottoNumber.getValue());
    }
    if (validateLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new LottoNumberDuplicateException();
    }
  }

  public static WinningLotto create(String winningLotto) {
    String[] splitWinningLotto = splitWinningLotto(winningLotto);
    List<LottoNumber> winningLottoNumbers = new ArrayList<>();
    for (String lottoNumber : splitWinningLotto) {
      winningLottoNumbers.add(LottoNumber.create(lottoNumber));
    }
    return new WinningLotto(winningLottoNumbers);
  }

  private static String[] splitWinningLotto(String winningLotto) {
    return winningLotto.split(WINNING_LOTTO_BASED_SPLIT_REGEX);
  }

  public List<LottoNumber> getWinningLottoNumbers() {
    return winningLottoNumbers;
  }
}
